import {computed, inject, Injectable, signal, WritableSignal} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpParams} from "@angular/common/http";
import {NgbModal, NgbModalRef} from "@ng-bootstrap/ng-bootstrap";
import Keycloak from "keycloak-js";
import {KeyCloakConfig} from "../constant/keycloak.config";
import {State} from "../shared/model/state.model";
import {ConnectedUser} from "../shared/model/user.model";
import {catchError, from, interval, Observable, of, shareReplay, switchMap} from "rxjs";
import {environment} from "../../environments/environment";
import {fromPromise} from "rxjs/internal/observable/innerFrom";
import {AuthModalComponent} from "./auth-modal/auth-modal.component";

@Injectable({
  providedIn: 'root'
})
export class Oauth2AuthService {
  public NOT_CONNECTED = 'NOT_CONNECTED';
  public accessToken: string | undefined;

  private TOKEN_VALIDITY_MILLISECONDS = 10000;
  private authModalRef: NgbModalRef | undefined;
  private keycloak = new Keycloak(KeyCloakConfig);
  private fetchUserHttp$ = new Observable<ConnectedUser>();

  private httpClient = inject(HttpClient);
  private modalService = inject(NgbModal);

  constructor() {
    this.initFetchUserCaching(false);
  }

  private fetchUser$: WritableSignal<State<ConnectedUser>> =
    signal(State.Builder<ConnectedUser>().forSuccess({email: this.NOT_CONNECTED}));
  fetchUser = computed(() => this.fetchUser$());

  public initAuthentication(): void {
    from(this.keycloak.init({
      flow: "standard",
      onLoad: "check-sso",
      redirectUri: "http://localhost:4200/",
      silentCheckSsoRedirectUri: window.location.origin + "/assets/silentCheckSsoRedirectUri.html",
    }))
      .subscribe(isAuthenticated => {
        if (isAuthenticated) {
          this.accessToken = this.keycloak.token;
          this.fetch();
          this.initUpdateTokenRefresh();
          if (this.authModalRef) {
            this.authModalRef.close();
          }
          // this.sseService.subscribe(this.accessToken!);
        } else {
          this.authModalRef = this.modalService
            .open(AuthModalComponent, {centered: true, backdrop: "static"});
        }
      });
  }

  initUpdateTokenRefresh(): void {
    interval(this.TOKEN_VALIDITY_MILLISECONDS)
      .pipe(
        switchMap(() => fromPromise(this.keycloak.updateToken(this.TOKEN_VALIDITY_MILLISECONDS)))
      ).subscribe({
      next: refreshed => {
        if (refreshed) {
          this.accessToken = this.keycloak.token;
        }
      },
      error: err => console.error("Failed to refresh token" + err)
    });
  }

  public initFetchUserCaching(forceResync: boolean): void {
    const params = new HttpParams().set("forceResync", forceResync);
    this.fetchUserHttp$ = this.httpClient.get<ConnectedUser>(`${environment.serverUrl}/users/get-authenticated-user`, {params: params})
      .pipe(
        catchError(() => of({email: this.NOT_CONNECTED})),
        shareReplay(1)
      );
  }

  public fetch(): void {
    this.fetchUserHttp$
      .subscribe({
        next: user => this.fetchUser$.set(State.Builder<ConnectedUser>().forSuccess(user)),
        error: (error: HttpErrorResponse) => {
          this.fetchUser$.set(State.Builder<ConnectedUser>().forError(error))
        }
      });
  }

  isAuthenticated(): boolean {
    return this.keycloak.authenticated!;
  }

  login(): void {
    this.keycloak.login();
  }

  logout(): void {
    this.keycloak.logout();
  }

  goToProfilePage(): void {
    this.keycloak.accountManagement();
  }
}

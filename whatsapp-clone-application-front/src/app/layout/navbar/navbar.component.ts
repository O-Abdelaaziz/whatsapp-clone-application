import {Component, effect, inject} from '@angular/core';
import {Oauth2AuthService} from "../../auth/oauth2-auth.service";
import {ConnectedUser} from "../../shared/model/user.model";
import {FaIconComponent} from "@fortawesome/angular-fontawesome";
import {
  NgbDropdown,
  NgbDropdownItem,
  NgbDropdownMenu,
  NgbDropdownToggle,
  NgbOffcanvas
} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'wac-navbar',
  standalone: true,
  imports: [
    FaIconComponent,
    NgbDropdown,
    NgbDropdownToggle,
    NgbDropdownMenu,
    NgbDropdownItem
  ],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.scss'
})
export class NavbarComponent {

  public connectedUser: ConnectedUser | undefined;
  public oauth2AuthService = inject(Oauth2AuthService);

  constructor() {
    this.listenToFetchedUser();
  }

  private listenToFetchedUser() {
    effect(() => {
      const userState = this.oauth2AuthService.fetchUser();
      if (userState.status === "OK"
        && userState.value?.email
        && userState.value.email !== this.oauth2AuthService.NOT_CONNECTED) {
        this.connectedUser = userState.value;
      }
    });
  }

  logout() {
    this.oauth2AuthService.logout()
  }

  editProfile() {
    this.oauth2AuthService.goToProfilePage();
  }

  openNewConversation() {
  }
}

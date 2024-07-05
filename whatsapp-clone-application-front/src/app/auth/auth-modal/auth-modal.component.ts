import {Component, inject} from '@angular/core';
import {NgOptimizedImage} from "@angular/common";
import {Oauth2AuthService} from "../oauth2-auth.service";

@Component({
  selector: 'wac-auth-modal',
  standalone: true,
  imports: [
    NgOptimizedImage
  ],
  templateUrl: './auth-modal.component.html',
  styleUrl: './auth-modal.component.scss'
})
export class AuthModalComponent {
  private oauth2Service = inject(Oauth2AuthService);

  login() {
    this.oauth2Service.login();
  }
}

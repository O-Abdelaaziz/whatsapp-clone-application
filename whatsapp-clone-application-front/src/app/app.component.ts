import {Component, inject, OnInit} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {NgbAccordionModule, NgbToast} from "@ng-bootstrap/ng-bootstrap";
import {FaIconComponent, FaIconLibrary} from "@fortawesome/angular-fontawesome";
import {fontAwesomeIcons} from "./shared/font-awesome-icons";
import {Oauth2AuthService} from "./auth/oauth2-auth.service";
import {NavbarComponent} from "./layout/navbar/navbar.component";
import dayjs from "dayjs";
import relativeTime from "dayjs/plugin/relativeTime";
import {ConversationsComponent} from "./conversations/conversations.component";
import {HeaderComponent} from "./layout/header/header.component";
import {SendComponent} from "./messages/send/send.component";
import {MessagesComponent} from "./messages/messages.component";
import {ToastService} from "./shared/toast/toast.service";

@Component({
  selector: 'wac-root',
  standalone: true,
  imports: [RouterOutlet, NgbAccordionModule, NavbarComponent, ConversationsComponent, HeaderComponent, SendComponent, MessagesComponent, NgbToast],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit {
  title = 'whatsapp-clone-application-front';

  private faIconLibrary = inject(FaIconLibrary);
  private oauth2AuthService = inject(Oauth2AuthService);
  toastService = inject(ToastService);

  protected readonly removeEventListener = removeEventListener;

  ngOnInit(): void {
    this.initAuthentication();
    this.initFontAwesome();
    this.configDayJs();
  }

  private initAuthentication() {
    this.oauth2AuthService.initAuthentication();
  }

  private configDayJs() {
    dayjs.extend(relativeTime);
  }

  private initFontAwesome() {
    this.faIconLibrary.addIcons(...fontAwesomeIcons);
  }
}

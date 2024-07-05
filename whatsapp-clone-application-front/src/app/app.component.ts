import {Component, inject, OnInit} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {NgbAccordionModule} from "@ng-bootstrap/ng-bootstrap";
import {FaIconComponent, FaIconLibrary} from "@fortawesome/angular-fontawesome";
import {fontAwesomeIcons} from "./shared/font-awesome-icons";
import {Oauth2AuthService} from "./auth/oauth2-auth.service";

@Component({
  selector: 'wac-root',
  standalone: true,
  imports: [RouterOutlet, NgbAccordionModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit {
  title = 'whatsapp-clone-application-front';

  private faIconLibrary = inject(FaIconLibrary);
  private oauth2AuthService = inject(Oauth2AuthService);

  ngOnInit(): void {
    this.initAuthentication();
    this.initFontAwesome();
  }

  private initAuthentication() {
    this.oauth2AuthService.initAuthentication();
  }

  private initFontAwesome() {
    this.faIconLibrary.addIcons(...fontAwesomeIcons);
  }
}

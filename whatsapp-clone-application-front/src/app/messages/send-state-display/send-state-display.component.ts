import {Component, input} from '@angular/core';
import {FaIconComponent} from "@fortawesome/angular-fontawesome";
import {Message} from "../../conversations/model/message.model";

@Component({
  selector: 'wac-send-state-display',
  standalone: true,
  imports: [
    FaIconComponent
  ],
  templateUrl: './send-state-display.component.html',
  styleUrl: './send-state-display.component.scss'
})
export class SendStateDisplayComponent {

  message = input.required<Message>();
}

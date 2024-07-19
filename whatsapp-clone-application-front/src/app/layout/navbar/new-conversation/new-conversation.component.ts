import {Component, inject, OnDestroy, OnInit} from '@angular/core';
import {UserSearchService} from "../user-search.service";
import {NgbActiveOffcanvas} from "@ng-bootstrap/ng-bootstrap";
import {ToastService} from "../../../shared/toast/toast.service";
import {BaseUser} from "../../../shared/model/user.model";
import {Pagination} from "../../../shared/model/request.model";
import {Subscription} from "rxjs";
import {SearchQuery} from "./model/user-search.model";
import {ConversationSelectorComponent} from "./conversation-selector/conversation-selector.component";
import {FormsModule} from "@angular/forms";
import {FaIconComponent} from "@fortawesome/angular-fontawesome";
import {ConversationService} from "../../../conversations/conversation.service";

@Component({
  selector: 'wac-new-conversation',
  standalone: true,
  imports: [
    ConversationSelectorComponent,
    FormsModule,
    FaIconComponent
  ],
  templateUrl: './new-conversation.component.html',
  styleUrl: './new-conversation.component.scss'
})
export class NewConversationComponent implements OnInit, OnDestroy {
  public query = '';
  public usersResults = new Array<BaseUser>();
  public loadingSearch = true;
  public searchSubscription: Subscription | undefined;
  public searchPage: Pagination = {
    page: 0,
    size: 20,
    sort: ['firstName', 'ASC'],
  };

  private searchService = inject(UserSearchService);
  private toastService = inject(ToastService);
  private activeOffCanvas = inject(NgbActiveOffcanvas);
  private conversationService=inject(ConversationService);

  ngOnInit(): void {
    this.initSearchResultListener();
  }

  ngOnDestroy(): void {
    if (this.searchSubscription) {
      this.searchSubscription.unsubscribe();
    }
  }

  onQueryChange(newQuery: string) {
    this.loadingSearch = true;
    const searchQuery: SearchQuery = {
      query: newQuery,
      page: this.searchPage
    }
    this.searchService.search(searchQuery);
  }

  initSearchResultListener(): void {
    this.searchSubscription = this.searchService.searchResult
      .subscribe(usersState => {
        if (usersState.status === "OK" && usersState.value) {
          this.usersResults = usersState.value;
        } else if (usersState.status === "ERROR") {
          this.toastService.show("An error occurred when fetching search result, please try again", "DANGER");
        }
        this.loadingSearch = false;
      });

    const searchQuery: SearchQuery = {
      query: "",
      page: this.searchPage
    }
    this.searchService.search(searchQuery);
  }


  onCloseNav() {
    this.activeOffCanvas.close();
  }

  handleConversation(userPublicId: string): void {
    this.conversationService.handleNavigateToConversation(userPublicId);
    this.activeOffCanvas.close();
  }
}

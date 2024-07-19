package com.whatsapp.clone.application.infrastructure.secondary.message;

/**
 * @Created 19/7/2024 - 2:03 PM on (Friday)
 * @Package com.whatsapp.clone.application.infrastructure.secondary.message
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public enum NotificationEventName {
    NEW_MESSAGE("message"), DELETE_CONVERSATION("delete-conversation"),
    VIEWS_MESSAGES("view-messages");

    final String value;

    NotificationEventName(String value) {
        this.value = value;
    }
}


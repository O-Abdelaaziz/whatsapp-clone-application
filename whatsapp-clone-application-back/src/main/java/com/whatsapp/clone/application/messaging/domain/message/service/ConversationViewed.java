package com.whatsapp.clone.application.messaging.domain.message.service;

import com.whatsapp.clone.application.infrastructure.secondary.message.ConversationViewedForNotification;
import com.whatsapp.clone.application.messaging.domain.message.aggregate.Message;
import com.whatsapp.clone.application.messaging.domain.message.repository.MessageRepository;
import com.whatsapp.clone.application.messaging.domain.message.vo.ConversationPublicId;
import com.whatsapp.clone.application.messaging.domain.message.vo.MessageSendState;
import com.whatsapp.clone.application.messaging.domain.user.service.UserReader;
import com.whatsapp.clone.application.messaging.domain.user.vo.UserPublicId;
import com.whatsapp.clone.application.shared.service.State;
import com.whatsapp.clone.application.messaging.domain.user.aggregate.User;

import java.util.List;

/**
 * @Created 7/7/2024 - 10:56 AM on (Sunday)
 * @Package com.whatsapp.clone.application.messaging.domain.message.service
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public class ConversationViewed {

    private final MessageRepository messageRepository;
    private final MessageChangeNotifier messageChangeNotifier;
    private final UserReader userReader;

    public ConversationViewed(MessageRepository messageRepository, MessageChangeNotifier messageChangeNotifier, UserReader userReader) {
        this.messageRepository = messageRepository;
        this.messageChangeNotifier = messageChangeNotifier;
        this.userReader = userReader;
    }

    public State<Integer, String> markAsRead(ConversationPublicId conversationPublicId, UserPublicId connectedUserPublicId) {
        List<Message> messageToUpdateSendState = messageRepository.findMessageToUpdateSendState(conversationPublicId, connectedUserPublicId);
        int nbUpdatedMessages = messageRepository.updateMessageSendState(conversationPublicId, connectedUserPublicId, MessageSendState.READ);
        List<UserPublicId> usersToNotify = userReader.findUsersToNotify(conversationPublicId, connectedUserPublicId)
                .stream().map(User::getUserPublicId).toList();
        ConversationViewedForNotification conversationViewedForNotification = new ConversationViewedForNotification(conversationPublicId.value(),
                messageToUpdateSendState.stream().map(message -> message.getPublicId().value()).toList());
        messageChangeNotifier.view(conversationViewedForNotification, usersToNotify);

        if (nbUpdatedMessages > 0) {
            return State.<Integer, String>builder().forSuccess(nbUpdatedMessages);
        } else {
            return State.<Integer, String>builder().forSuccess();
        }
    }
}


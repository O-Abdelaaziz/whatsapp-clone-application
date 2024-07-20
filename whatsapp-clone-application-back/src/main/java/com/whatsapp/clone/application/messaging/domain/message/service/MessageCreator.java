package com.whatsapp.clone.application.messaging.domain.message.service;

import com.whatsapp.clone.application.messaging.domain.message.aggregate.Conversation;
import com.whatsapp.clone.application.messaging.domain.message.aggregate.Message;
import com.whatsapp.clone.application.messaging.domain.message.aggregate.MessageBuilder;
import com.whatsapp.clone.application.messaging.domain.message.aggregate.MessageSendNew;
import com.whatsapp.clone.application.messaging.domain.message.repository.MessageRepository;
import com.whatsapp.clone.application.messaging.domain.message.vo.MessagePublicId;
import com.whatsapp.clone.application.messaging.domain.message.vo.MessageSendState;
import com.whatsapp.clone.application.messaging.domain.message.vo.MessageSentTime;
import com.whatsapp.clone.application.messaging.domain.user.aggregate.User;
import com.whatsapp.clone.application.shared.service.State;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

/**
 * @Created 19/7/2024 - 9:35 PM on (Friday)
 * @Package com.whatsapp.clone.application.messaging.service
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public class MessageCreator {
    private final MessageRepository messageRepository;
    private final MessageChangeNotifier messageChangeNotifier;
    private final ConversationReader conversationReader;

    public MessageCreator(MessageRepository messageRepository, MessageChangeNotifier messageChangeNotifier,
                          ConversationReader conversationReader) {
        this.messageRepository = messageRepository;
        this.messageChangeNotifier = messageChangeNotifier;
        this.conversationReader = conversationReader;
    }


    public State<Message, String> create(MessageSendNew messageSendNew, User sender) {
        Message newMessage = MessageBuilder.message()
                .content(messageSendNew.messageContent())
                .publicId(new MessagePublicId(UUID.randomUUID()))
                .sendState(MessageSendState.RECEIVED)
                .sentTime(new MessageSentTime(Instant.now()))
                .conversationId(messageSendNew.conversationPublicId())
                .sender(sender.getUserPublicId())
                .build();

        State<Message, String> creationState;
        Optional<Conversation> conversationToLink = conversationReader.getOneByPublicId(messageSendNew.conversationPublicId());
        if (conversationToLink.isPresent()) {
            Message messageSaved = messageRepository.save(newMessage, sender, conversationToLink.get());
            messageChangeNotifier.send(newMessage, conversationToLink.get().getMembers().stream()
                    .map(User::getUserPublicId).toList());
            creationState = State.<Message, String>builder().forSuccess(messageSaved);
        } else {
            creationState = State.<Message, String>builder().forError(
                    String.format("Unable to find the conversation to link the message with the " +
                            "following publicId %s", messageSendNew.conversationPublicId().value())
            );
        }
        return creationState;
    }
}

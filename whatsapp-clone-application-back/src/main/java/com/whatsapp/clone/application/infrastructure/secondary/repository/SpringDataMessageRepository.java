package com.whatsapp.clone.application.infrastructure.secondary.repository;

import com.whatsapp.clone.application.messaging.domain.message.aggregate.Conversation;
import com.whatsapp.clone.application.messaging.domain.message.aggregate.Message;
import com.whatsapp.clone.application.messaging.domain.message.repository.MessageRepository;
import com.whatsapp.clone.application.messaging.domain.message.vo.ConversationPublicId;
import com.whatsapp.clone.application.messaging.domain.message.vo.MessageSendState;
import com.whatsapp.clone.application.messaging.domain.user.aggregate.User;
import com.whatsapp.clone.application.messaging.domain.user.vo.UserPublicId;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Created 4/7/2024 - 6:51 PM on (Thursday)
 * @Package com.whatsapp.clone.application.infrastructure.secondary.repository
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Repository
public class SpringDataMessageRepository implements MessageRepository {
    @Override
    public Message save(Message message, User sender, Conversation conversation) {
        return null;
    }

    @Override
    public int updateMessageSendState(ConversationPublicId conversationPublicId, UserPublicId userPublicId, MessageSendState state) {
        return 0;
    }

    @Override
    public List<Message> findMessageToUpdateSendState(ConversationPublicId conversationPublicId, UserPublicId userPublicId) {
        return List.of();
    }
}

package com.whatsapp.clone.application.messaging.domain.message.service;

import com.whatsapp.clone.application.messaging.domain.message.aggregate.Conversation;
import com.whatsapp.clone.application.messaging.domain.message.repository.ConversationRepository;
import com.whatsapp.clone.application.messaging.domain.message.vo.ConversationPublicId;
import com.whatsapp.clone.application.messaging.domain.user.vo.UserPublicId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * @Created 6/7/2024 - 9:38 AM on (Saturday)
 * @Package com.whatsapp.clone.application.messaging.service
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public class ConversationReader {

    private final ConversationRepository conversationRepository;

    public ConversationReader(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    public Page<Conversation> getAllByUserPublicID(UserPublicId userPublicId, Pageable pageable) {
        return conversationRepository.getConversationByUserPublicId(userPublicId, pageable);
    }

    public Optional<Conversation> getOneByPublicId(ConversationPublicId conversationPublicId) {
        return conversationRepository.getOneByPublicId(conversationPublicId);
    }

    public Optional<Conversation> getOneByPublicIdAndUserId(ConversationPublicId conversationPublicId, UserPublicId userPublicId) {
        return conversationRepository.getConversationByUsersPublicIdAndPublicId(userPublicId, conversationPublicId);
    }
}


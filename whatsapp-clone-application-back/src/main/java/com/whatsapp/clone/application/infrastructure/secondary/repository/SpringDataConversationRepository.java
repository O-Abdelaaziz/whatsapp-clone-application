package com.whatsapp.clone.application.infrastructure.secondary.repository;

import com.whatsapp.clone.application.messaging.domain.message.aggregate.Conversation;
import com.whatsapp.clone.application.messaging.domain.message.aggregate.ConversationToCreate;
import com.whatsapp.clone.application.messaging.domain.message.repository.ConversationRepository;
import com.whatsapp.clone.application.messaging.domain.message.vo.ConversationPublicId;
import com.whatsapp.clone.application.messaging.domain.user.aggregate.User;
import com.whatsapp.clone.application.messaging.domain.user.vo.UserPublicId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @Created 4/7/2024 - 6:49 PM on (Thursday)
 * @Package com.whatsapp.clone.application.infrastructure.secondary.repository
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Repository
public class SpringDataConversationRepository implements ConversationRepository {
    @Override
    public Conversation save(ConversationToCreate conversation, List<User> members) {
        return null;
    }

    @Override
    public Optional<Conversation> get(ConversationPublicId conversationPublicId) {
        return Optional.empty();
    }

    @Override
    public Page<Conversation> getConversationByUserPublicId(UserPublicId publicId, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Conversation> getConversationByUsersPublicIdAndPublicId(UserPublicId userPublicId, ConversationPublicId conversationPublicId) {
        return Optional.empty();
    }

    @Override
    public Optional<Conversation> getConversationByUserPublicIds(List<UserPublicId> publicIds) {
        return Optional.empty();
    }

    @Override
    public Optional<Conversation> getOneByPublicId(ConversationPublicId conversationPublicId) {
        return Optional.empty();
    }
}

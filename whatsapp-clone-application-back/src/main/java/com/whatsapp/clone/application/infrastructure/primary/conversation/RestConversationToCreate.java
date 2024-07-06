package com.whatsapp.clone.application.infrastructure.primary.conversation;

import com.whatsapp.clone.application.messaging.domain.message.aggregate.ConversationToCreate;
import com.whatsapp.clone.application.messaging.domain.message.aggregate.ConversationToCreateBuilder;
import com.whatsapp.clone.application.messaging.domain.message.vo.ConversationName;
import com.whatsapp.clone.application.messaging.domain.user.vo.UserPublicId;
import org.jilt.Builder;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Created 6/7/2024 - 11:47 AM on (Saturday)
 * @Package com.whatsapp.clone.application.infrastructure.primary.conversation
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Builder
public record RestConversationToCreate(Set<UUID> members, String name) {

    public static ConversationToCreate toDomain(RestConversationToCreate restConversationToCreate) {
        RestConversationToCreateBuilder restConversationToCreateBuilder = RestConversationToCreateBuilder.restConversationToCreate();

        Set<UserPublicId> userUUIDs = restConversationToCreate.members
                .stream()
                .map(UserPublicId::new)
                .collect(Collectors.toSet());

        return ConversationToCreateBuilder.conversationToCreate()
                .name(new ConversationName(restConversationToCreate.name()))
                .members(userUUIDs)
                .build();
    }
}

package com.whatsapp.clone.application.infrastructure.primary.conversation;

import com.whatsapp.clone.application.infrastructure.primary.message.RestMessage;
import com.whatsapp.clone.application.messaging.domain.message.aggregate.Conversation;
import org.jilt.Builder;

import java.util.List;
import java.util.UUID;

/**
 * @Created 6/7/2024 - 11:45 AM on (Saturday)
 * @Package com.whatsapp.clone.application.infrastructure.primary.conversation
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Builder
public record RestConversation(UUID publicId, String name,
                               List<RestUserForConversation> members,
                               List<RestMessage> messages) {

    public static RestConversation from(Conversation conversation) {
        RestConversationBuilder restConversationBuilder = RestConversationBuilder.restConversation()
                .name(conversation.getConversationName().name())
                .publicId(conversation.getConversationPublicId().value())
                .members(RestUserForConversation.from(conversation.getMembers()));

        if (conversation.getMessages() != null) {
            restConversationBuilder.messages(RestMessage.from(conversation.getMessages()));
        }

        return restConversationBuilder.build();
    }

}

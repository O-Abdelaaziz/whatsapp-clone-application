package com.whatsapp.clone.application.infrastructure.primary.conversation;

import com.whatsapp.clone.application.messaging.domain.user.aggregate.User;
import org.jilt.Builder;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @Created 6/7/2024 - 11:46 AM on (Saturday)
 * @Package com.whatsapp.clone.application.infrastructure.primary.conversation
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Builder
public record RestUserForConversation(String lastName, String firstName,
                                      UUID publicId, String imageUrl,
                                      Instant lastSeen) {

    public static RestUserForConversation from(User user) {
        RestUserForConversationBuilder restUserForConversationBuilder = RestUserForConversationBuilder.restUserForConversation();

        if (user.getImageUrl() != null) {
            restUserForConversationBuilder.imageUrl(user.getImageUrl().value());
        }

        return restUserForConversationBuilder
                .lastName(user.getLastName().value())
                .firstName(user.getFirstname().value())
                .publicId(user.getUserPublicId().value())
                .lastSeen(user.getLastSeen())
                .build();
    }

    public static List<RestUserForConversation> from(Set<User> users) {
        return users.stream().map(RestUserForConversation::from).toList();
    }
}


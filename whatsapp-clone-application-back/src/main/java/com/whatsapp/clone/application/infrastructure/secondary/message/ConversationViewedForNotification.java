package com.whatsapp.clone.application.infrastructure.secondary.message;

import java.util.List;
import java.util.UUID;

/**
 * @Created 7/7/2024 - 11:08 AM on (Sunday)
 * @Package com.whatsapp.clone.application.infrastructure.secondary.message
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public record ConversationViewedForNotification(UUID conversationId,
                                                List<UUID> messageIdsViewed) {
}

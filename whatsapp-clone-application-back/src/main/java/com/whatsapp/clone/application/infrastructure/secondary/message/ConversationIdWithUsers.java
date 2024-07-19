package com.whatsapp.clone.application.infrastructure.secondary.message;

import com.whatsapp.clone.application.messaging.domain.message.vo.ConversationPublicId;
import com.whatsapp.clone.application.messaging.domain.user.vo.UserPublicId;

import java.util.List;

/**
 * @Created 19/7/2024 - 1:19 PM on (Friday)
 * @Package com.whatsapp.clone.application.infrastructure.secondary.message
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public record ConversationIdWithUsers(ConversationPublicId conversationPublicId,
                                      List<UserPublicId> users) {
}


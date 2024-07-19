package com.whatsapp.clone.application.infrastructure.secondary.message;

import com.whatsapp.clone.application.messaging.domain.message.aggregate.Message;
import com.whatsapp.clone.application.messaging.domain.user.vo.UserPublicId;

import java.util.List;

/**
 * @Created 19/7/2024 - 10:35 PM on (Friday)
 * @Package com.whatsapp.clone.application.infrastructure.secondary.message
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public record MessageWithUsers(Message message, List<UserPublicId> userToNotify) {
}

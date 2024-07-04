package com.whatsapp.clone.application.messaging.domain.message.vo;

import org.springframework.util.Assert;

import java.util.UUID;

/**
 * @Created 4/7/2024 - 5:09 PM on (Thursday)
 * @Package com.whatsapp.clone.application.messaging.domain.message.vo
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public record ConversationPublicId(UUID value) {
    public ConversationPublicId {
        Assert.notNull(value, "public id cannot be null");
    }
}

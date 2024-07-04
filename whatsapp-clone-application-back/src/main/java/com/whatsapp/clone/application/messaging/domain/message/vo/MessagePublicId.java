package com.whatsapp.clone.application.messaging.domain.message.vo;

import org.springframework.util.Assert;

import java.util.UUID;

/**
 * @Created 4/7/2024 - 5:12 PM on (Thursday)
 * @Package com.whatsapp.clone.application.messaging.domain.message.vo
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public record MessagePublicId(UUID value) {

    public MessagePublicId {
        Assert.notNull(value, "Id can't be null");
    }
}
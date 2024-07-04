package com.whatsapp.clone.application.messaging.domain.user.vo;

import org.springframework.util.Assert;

import java.util.UUID;

/**
 * @Created 4/7/2024 - 5:27 PM on (Thursday)
 * @Package com.whatsapp.clone.application.messaging.domain.user.vo
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public record UserPublicId(UUID value) {
    public UserPublicId {
        Assert.notNull(value, "value cannot be null");
    }
}

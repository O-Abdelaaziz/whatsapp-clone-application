package com.whatsapp.clone.application.messaging.domain.message.vo;

import com.whatsapp.clone.application.shared.error.domain.Assert;

/**
 * @Created 4/7/2024 - 5:07 PM on (Thursday)
 * @Package com.whatsapp.clone.application.messaging.domain.message.vo
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public record ConversationName(String name) {
    public ConversationName {
        Assert.field("name", name).minLength(3).maxLength(255);
    }
}

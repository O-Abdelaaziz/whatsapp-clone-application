package com.whatsapp.clone.application.messaging.domain.message.aggregate;

import com.whatsapp.clone.application.shared.error.domain.Assert;

import java.util.List;

/**
 * @Created 4/7/2024 - 5:23 PM on (Thursday)
 * @Package com.whatsapp.clone.application.messaging.domain.message.aggregate
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public record Messages(List<Messages> messages) {
    public Messages {
        Assert.field("messages", messages).notNull().noNullElement();
    }
}

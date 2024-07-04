package com.whatsapp.clone.application.messaging.domain.message.vo;

import com.whatsapp.clone.application.shared.error.domain.Assert;

import java.time.Instant;

/**
 * @Created 4/7/2024 - 5:14 PM on (Thursday)
 * @Package com.whatsapp.clone.application.messaging.domain.message.vo
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public record MessageSentTime(Instant date) {
    public MessageSentTime {
        Assert.field("date", date).notNull();
    }
}

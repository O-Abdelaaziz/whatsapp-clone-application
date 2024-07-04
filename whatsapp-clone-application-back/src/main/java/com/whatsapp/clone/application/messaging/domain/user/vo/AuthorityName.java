package com.whatsapp.clone.application.messaging.domain.user.vo;

import com.whatsapp.clone.application.shared.error.domain.Assert;

/**
 * @Created 4/7/2024 - 5:40 PM on (Thursday)
 * @Package com.whatsapp.clone.application.messaging.domain.user.vo
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public record AuthorityName(String name) {

    public AuthorityName {
        Assert.field("name", name).notNull();
    }
}

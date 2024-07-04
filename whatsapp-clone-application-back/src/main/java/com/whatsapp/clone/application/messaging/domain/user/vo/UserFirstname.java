package com.whatsapp.clone.application.messaging.domain.user.vo;

import com.whatsapp.clone.application.shared.error.domain.Assert;

/**
 * @Created 4/7/2024 - 5:44 PM on (Thursday)
 * @Package com.whatsapp.clone.application.messaging.domain.user.vo
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public record UserFirstname(String value) {

    public UserFirstname {
        Assert.field(value, value).maxLength(255);
    }
}

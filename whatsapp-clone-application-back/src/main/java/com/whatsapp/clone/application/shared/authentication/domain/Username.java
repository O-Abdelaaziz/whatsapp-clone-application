package com.whatsapp.clone.application.shared.authentication.domain;

import com.whatsapp.clone.application.shared.error.domain.Assert;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

/**
 * @Created 4/7/2024 - 12:53 PM on (Thursday)
 * @Package com.whatsapp.clone.application.shared.authentication.domain
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public record Username(String username) {
    public Username {
        Assert.field("username", username).notBlank().maxLength(100);
    }

    public String get() {
        return username();
    }

    public static Optional<Username> of(String username) {
        return Optional.ofNullable(username).filter(StringUtils::isNotBlank).map(Username::new);
    }
}

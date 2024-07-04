package com.whatsapp.clone.application.messaging.domain.user.aggregate;

import com.whatsapp.clone.application.messaging.domain.user.vo.AuthorityName;
import com.whatsapp.clone.application.shared.error.domain.Assert;
import org.jilt.Builder;

/**
 * @Created 4/7/2024 - 5:39 PM on (Thursday)
 * @Package com.whatsapp.clone.application.messaging.domain.user.aggregate
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Builder
public class Authority {

    private AuthorityName name;

    public Authority(AuthorityName name) {
        Assert.notNull("name", name);
        this.name = name;
    }

    public AuthorityName getName() {
        return name;
    }
}

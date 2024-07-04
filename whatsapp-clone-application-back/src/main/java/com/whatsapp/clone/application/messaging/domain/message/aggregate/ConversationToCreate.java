package com.whatsapp.clone.application.messaging.domain.message.aggregate;

import com.whatsapp.clone.application.messaging.domain.message.vo.ConversationName;
import com.whatsapp.clone.application.messaging.domain.user.vo.UserPublicId;
import com.whatsapp.clone.application.shared.error.domain.Assert;
import lombok.Builder;

import java.util.Set;

/**
 * @Created 4/7/2024 - 5:22 PM on (Thursday)
 * @Package com.whatsapp.clone.application.messaging.domain.message.aggregate
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Builder
public class ConversationToCreate {

    private final Set<UserPublicId> members;

    private final ConversationName name;

    public ConversationToCreate(Set<UserPublicId> members, ConversationName name) {
        assertMandatoryFields(members, name);
        this.members = members;
        this.name = name;
    }

    private void assertMandatoryFields(Set<UserPublicId> members, ConversationName name) {
        Assert.notNull("name", name);
        Assert.notNull("members", members);
    }

    public Set<UserPublicId> getMembers() {
        return members;
    }

    public ConversationName getName() {
        return name;
    }
}

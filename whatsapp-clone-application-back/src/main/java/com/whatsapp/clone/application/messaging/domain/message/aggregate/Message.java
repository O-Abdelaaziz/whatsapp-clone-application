package com.whatsapp.clone.application.messaging.domain.message.aggregate;

import com.whatsapp.clone.application.messaging.domain.message.vo.*;
import com.whatsapp.clone.application.messaging.domain.user.vo.UserPublicId;
import com.whatsapp.clone.application.shared.error.domain.Assert;
import lombok.Builder;

/**
 * @Created 4/7/2024 - 5:18 PM on (Thursday)
 * @Package com.whatsapp.clone.application.messaging.domain.message.aggregate
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Builder
public class Message {

    private final MessageSentTime sentTime;

    private final MessageContent content;

    private final MessageSendState sendState;

    private final MessagePublicId publicId;

    private final UserPublicId sender;

    private final ConversationPublicId conversationId;

    public Message(MessageSentTime sentTime, MessageContent content,
                   MessageSendState sendState, MessagePublicId publicId,
                   UserPublicId sender, ConversationPublicId conversationId) {
        assertMandatoryFields(sentTime, content, sendState, publicId, sender, conversationId);
        this.sentTime = sentTime;
        this.content = content;
        this.sendState = sendState;
        this.publicId = publicId;
        this.sender = sender;
        this.conversationId = conversationId;
    }

    private void assertMandatoryFields(MessageSentTime sentTime,
                                       MessageContent content,
                                       MessageSendState state,
                                       MessagePublicId publicId,
                                       UserPublicId sender,
                                       ConversationPublicId conversationId) {
        Assert.notNull("sentTime", sentTime);
        Assert.notNull("content", content);
        Assert.notNull("state", state);
        Assert.notNull("publicId", publicId);
        Assert.notNull("sender", sender);
        Assert.notNull("conversationId", conversationId);
    }

    public MessageSentTime getSentTime() {
        return sentTime;
    }

    public MessageContent getContent() {
        return content;
    }

    public MessageSendState getSendState() {
        return sendState;
    }

    public MessagePublicId getPublicId() {
        return publicId;
    }

    public UserPublicId getSender() {
        return sender;
    }

    public ConversationPublicId getConversationId() {
        return conversationId;
    }
}

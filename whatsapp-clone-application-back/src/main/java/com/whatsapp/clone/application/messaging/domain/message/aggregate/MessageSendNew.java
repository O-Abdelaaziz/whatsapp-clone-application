package com.whatsapp.clone.application.messaging.domain.message.aggregate;

import com.whatsapp.clone.application.messaging.domain.message.vo.ConversationPublicId;
import com.whatsapp.clone.application.messaging.domain.message.vo.MessageContent;
import org.jilt.Builder;

/**
 * @Created 4/7/2024 - 5:24 PM on (Thursday)
 * @Package com.whatsapp.clone.application.messaging.domain.message.aggregate
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Builder
public record MessageSendNew(MessageContent messageContent,
                             ConversationPublicId conversationPublicId) {
}

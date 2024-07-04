package com.whatsapp.clone.application.messaging.domain.message.vo;

import org.jilt.Builder;




/**
 * @Created 4/7/2024 - 5:11 PM on (Thursday)
 * @Package com.whatsapp.clone.application.messaging.domain.message.vo
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Builder
public record MessageContent(String text,
                             MessageType type,
                             MessageMediaContent media) {
}
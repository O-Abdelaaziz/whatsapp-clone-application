package com.whatsapp.clone.application.messaging.domain.message.vo;

/**
 * @Created 4/7/2024 - 5:12 PM on (Thursday)
 * @Package com.whatsapp.clone.application.messaging.domain.message.vo
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public record MessageMediaContent(byte[] file,
                                  String mimetype) {
}

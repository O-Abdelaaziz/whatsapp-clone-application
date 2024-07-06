package com.whatsapp.clone.application.messaging.service;

import com.whatsapp.clone.application.messaging.domain.message.aggregate.Message;
import com.whatsapp.clone.application.messaging.domain.message.vo.ConversationPublicId;
import com.whatsapp.clone.application.messaging.domain.user.vo.UserPublicId;
import com.whatsapp.clone.application.shared.service.State;

import java.util.List;

/**
 * @Created 6/7/2024 - 10:18 AM on (Saturday)
 * @Package com.whatsapp.clone.application.messaging.service
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public interface MessageChangeNotifier {

    State<Void, String> send(Message message, List<UserPublicId> userToNotify);

    State<Void, String> delete(ConversationPublicId conversationPublicId, List<UserPublicId> userToNotify);

//    State<Void, String> view(ConversationViewedForNotification conversationViewedForNotification, List<UserPublicId> usersToNotify);
}

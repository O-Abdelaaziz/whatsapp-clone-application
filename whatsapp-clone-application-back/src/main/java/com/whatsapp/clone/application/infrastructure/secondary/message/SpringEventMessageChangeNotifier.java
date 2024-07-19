package com.whatsapp.clone.application.infrastructure.secondary.message;

import com.whatsapp.clone.application.messaging.domain.message.aggregate.Message;
import com.whatsapp.clone.application.messaging.domain.message.vo.ConversationPublicId;
import com.whatsapp.clone.application.messaging.domain.user.vo.UserPublicId;
import com.whatsapp.clone.application.messaging.service.MessageChangeNotifier;
import com.whatsapp.clone.application.shared.service.State;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created 6/7/2024 - 11:05 AM on (Saturday)
 * @Package com.whatsapp.clone.application.infrastructure.message
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Service
public class SpringEventMessageChangeNotifier implements MessageChangeNotifier {

    @Override
    public State<Void, String> send(Message message, List<UserPublicId> userToNotify) {
        return null;
    }

    @Override
    public State<Void, String> delete(ConversationPublicId conversationPublicId, List<UserPublicId> userToNotify) {
        return null;
    }

    @Override
    public State<Void, String> view(ConversationViewedForNotification conversationViewedForNotification, List<UserPublicId> usersToNotify) {
        return null;
    }
}

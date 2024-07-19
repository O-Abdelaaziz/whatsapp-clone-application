package com.whatsapp.clone.application.messaging.application;
import com.whatsapp.clone.application.messaging.domain.message.aggregate.Message;
import com.whatsapp.clone.application.messaging.domain.message.aggregate.MessageSendNew;
import com.whatsapp.clone.application.messaging.domain.message.repository.ConversationRepository;
import com.whatsapp.clone.application.messaging.domain.message.repository.MessageRepository;
import com.whatsapp.clone.application.messaging.domain.user.aggregate.User;
import com.whatsapp.clone.application.messaging.domain.user.repository.UserRepository;
import com.whatsapp.clone.application.messaging.domain.user.service.UserReader;
import com.whatsapp.clone.application.messaging.domain.user.vo.UserEmail;
import com.whatsapp.clone.application.messaging.service.ConversationReader;
import com.whatsapp.clone.application.messaging.service.MessageChangeNotifier;
import com.whatsapp.clone.application.messaging.service.MessageCreator;
import com.whatsapp.clone.application.shared.authentication.application.AuthenticatedUser;
import com.whatsapp.clone.application.shared.service.State;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
/**
 * @Created 19/7/2024 - 9:50 PM on (Friday)
 * @Package com.whatsapp.clone.application.messaging.application
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Service
public class MessageApplicationService {

    private final MessageCreator messageCreator;
    private final UserReader userReader;

    public MessageApplicationService(MessageRepository messageRepository, UserRepository userRepository,
                                     ConversationRepository conversationRepository, MessageChangeNotifier messageChangeNotifier) {
        ConversationReader conversationReader = new ConversationReader(conversationRepository);
        this.messageCreator = new MessageCreator(messageRepository, messageChangeNotifier, conversationReader);
        this.userReader = new UserReader(userRepository);
    }

    @Transactional
    public State<Message, String> send(MessageSendNew messageSendNew) {
        State<Message, String> creationState;
        Optional<User> connectedUser = this.userReader.getByEmail(new UserEmail(AuthenticatedUser.username().username()));
        if(connectedUser.isPresent()) {
            creationState = this.messageCreator.create(messageSendNew, connectedUser.get());
        } else {
            creationState = State.<Message, String>builder()
                    .forError(String.format("Error retrieving user information inside the DB : %s", AuthenticatedUser.username().username()));
        }
        return creationState;
    }
}

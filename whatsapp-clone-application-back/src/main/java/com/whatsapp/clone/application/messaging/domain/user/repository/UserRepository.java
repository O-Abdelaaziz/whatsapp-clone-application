package com.whatsapp.clone.application.messaging.domain.user.repository;

import com.whatsapp.clone.application.messaging.domain.message.vo.ConversationPublicId;
import com.whatsapp.clone.application.messaging.domain.user.aggregate.User;
import com.whatsapp.clone.application.messaging.domain.user.vo.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @Created 4/7/2024 - 6:54 PM on (Thursday)
 * @Package com.whatsapp.clone.application.messaging.domain.user.repository
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public interface UserRepository {

    void save(User user);

    Optional<User> get(UserPublicId userPublicId);

    Optional<User> getOneByEmail(UserEmail userEmail);

    List<User> getByPublicIds(Set<UserPublicId> userPublicIds);

    Page<User> search(Pageable pageable, String query);

    int updateLastSeenByPublicId(UserPublicId userPublicId, Instant lastSeen);

    List<User> getRecipientByConversationIdExcludingReader(ConversationPublicId conversationPublicId, UserPublicId readerPublicId);

    Optional<User> getOneByPublicId(UserPublicId userPublicId);

}

package com.whatsapp.clone.application.messaging.domain.user.service;

import com.whatsapp.clone.application.messaging.domain.user.aggregate.User;
import com.whatsapp.clone.application.messaging.domain.user.repository.UserRepository;
import com.whatsapp.clone.application.messaging.domain.user.vo.UserPublicId;

import java.time.Instant;
import java.util.Optional;

/**
 * @Created 5/7/2024 - 9:22 AM on (Friday)
 * @Package com.whatsapp.clone.application.messaging.domain.user.service
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public class UserPresence {

    private final UserRepository userRepository;
    private final UserReader userReader;

    public UserPresence(UserRepository userRepository, UserReader userReader) {
        this.userRepository = userRepository;
        this.userReader = userReader;
    }

    public void updatePresence(UserPublicId userPublicId) {
        userRepository.updateLastSeenByPublicId(userPublicId, Instant.now());
    }

    public Optional<Instant> getLastSeenByPublicId(UserPublicId userPublicId) {
        Optional<User> byPublicId = userReader.getByPublicId(userPublicId);
        return byPublicId.map(User::getLastSeen);
    }
}


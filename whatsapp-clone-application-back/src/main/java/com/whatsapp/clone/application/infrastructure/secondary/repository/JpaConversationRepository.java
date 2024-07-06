package com.whatsapp.clone.application.infrastructure.secondary.repository;

import com.whatsapp.clone.application.infrastructure.secondary.entity.ConversationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Created 4/7/2024 - 6:50 PM on (Thursday)
 * @Package com.whatsapp.clone.application.infrastructure.secondary.repository
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public interface JpaConversationRepository extends JpaRepository<ConversationEntity, Long> {
    Page<ConversationEntity> findAllByUsersPublicId(UUID publicId, Pageable pageable);

    int deleteByUsersPublicIdAndPublicId(UUID userPublicId, UUID conversationPublicId);

    Optional<ConversationEntity> findOneByUsersPublicIdAndPublicId(UUID userPublicId, UUID conversationPublicId);

    @Query("SELECT conversation FROM ConversationEntity conversation " +
            "JOIN conversation.users users " +
            "WHERE users.publicId IN :userPublicIds " +
            "GROUP BY conversation.id " +
            "HAVING COUNT(users.id) = :userCount")
    Optional<ConversationEntity> findOneByUsersPublicIdIn(List<UUID> userPublicIds, int userCount);

    Optional<ConversationEntity> findOneByPublicId(UUID publicId);
}

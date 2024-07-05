package com.whatsapp.clone.application.infrastructure.secondary.repository;

import com.whatsapp.clone.application.infrastructure.secondary.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


/**
 * @Created 4/7/2024 - 6:57 PM on (Thursday)
 * @Package com.whatsapp.clone.application.infrastructure.secondary.repository
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);

    @Query("SELECT user FROM UserEntity user WHERE lower(user.lastName) LIKE lower(concat('%', :query, '%')) " +
            "OR lower(user.firstName) LIKE lower(concat('%', :query, '%'))")
    Page<UserEntity> search(Pageable pageable, String query);

    List<UserEntity> findByPublicIdIn(List<UUID> publicIds);

    @Modifying
    @Query("UPDATE UserEntity  user SET user.lastSeen = :lastSeen WHERE user.publicId = :userPublicID")
    int updateLastSeen(UUID userPublicID, Instant lastSeen);

    Optional<UserEntity> findOneByPublicId(UUID publicId);

    List<UserEntity> findByConversationsPublicIdAndPublicIdIsNot(UUID conversationsPublicId, UUID publicIdToExclude);
}


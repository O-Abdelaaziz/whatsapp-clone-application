package com.whatsapp.clone.application.infrastructure.secondary.repository;

import com.whatsapp.clone.application.infrastructure.secondary.entity.MessageEntity;
import com.whatsapp.clone.application.messaging.domain.message.vo.MessageSendState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

/**
 * @Created 4/7/2024 - 6:52 PM on (Thursday)
 * @Package com.whatsapp.clone.application.infrastructure.secondary.repository
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public interface JpaMessageRepository extends JpaRepository<MessageEntity, Long> {
    @Modifying
    @Query("UPDATE MessageEntity  message SET message.sendState = :sendState " +
            "WHERE message.conversation.publicId = :conversationId " +
            "AND message.sender.publicId != :userPublicId " +
            "AND :userPublicId IN (SELECT user.publicId FROM message.conversation.users user) " +
            "AND message.sendState = 'RECEIVED'")
    int updateMessageSendState(UUID conversationId, UUID userPublicId, MessageSendState sendState);

    @Query("SELECT message FROM MessageEntity message " +
            "WHERE message.conversation.publicId = :conversationId " +
            "AND message.sender.publicId != :userPublicId " +
            "AND :userPublicId IN (SELECT user.publicId FROM message.conversation.users user) " +
            "AND message.sendState = 'RECEIVED'")
    List<MessageEntity> findMessageToUpdateSendState(UUID conversationId, UUID userPublicId);
}

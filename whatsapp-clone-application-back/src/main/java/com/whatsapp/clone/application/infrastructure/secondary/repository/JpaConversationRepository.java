package com.whatsapp.clone.application.infrastructure.secondary.repository;

import com.whatsapp.clone.application.infrastructure.secondary.entity.ConversationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Created 4/7/2024 - 6:50 PM on (Thursday)
 * @Package com.whatsapp.clone.application.infrastructure.secondary.repository
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public interface JpaConversationRepository extends JpaRepository<ConversationEntity, Long> {
}

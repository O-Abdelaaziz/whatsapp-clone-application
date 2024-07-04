package com.whatsapp.clone.application.wire.postgresql.infrastructure;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @Created 4/7/2024 - 1:27 PM on (Thursday)
 * @Package com.whatsapp.clone.application.wire.postgresql.infrastructure
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.whatsapp.clone.application"})
@EnableJpaAuditing
public class DatabaseConfiguration {
}

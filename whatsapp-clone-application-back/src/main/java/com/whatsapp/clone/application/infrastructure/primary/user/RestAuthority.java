package com.whatsapp.clone.application.infrastructure.primary.user;

import com.whatsapp.clone.application.messaging.domain.user.aggregate.Authority;
import org.jilt.Builder;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Created 5/7/2024 - 9:28 AM on (Friday)
 * @Package com.whatsapp.clone.application.infrastructure.primary.user
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
@Builder
public record RestAuthority(String name) {

    public static Set<RestAuthority> fromSet(Set<Authority> authorities) {
        return authorities.stream()
                .map(authority -> RestAuthorityBuilder.restAuthority().name(authority.getName().name()).build())
                .collect(Collectors.toSet());
    }

}

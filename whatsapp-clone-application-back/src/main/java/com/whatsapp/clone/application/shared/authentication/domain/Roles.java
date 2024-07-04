package com.whatsapp.clone.application.shared.authentication.domain;

import com.whatsapp.clone.application.shared.error.domain.Assert;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @Created 4/7/2024 - 12:52 PM on (Thursday)
 * @Package com.whatsapp.clone.application.shared.authentication.domain
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public record Roles(Set<Role> roles) {

    public static final Roles EMPTY = new Roles(null);

    public Roles(Set<Role> roles) {
        this.roles = Collections.unmodifiableSet(roles);
    }

    public boolean hasRole() {
        return !roles.isEmpty();
    }

    public boolean hasRole(Role role) {
        Assert.notNull("role", role);

        return roles.contains(role);
    }

    public Stream<Role> stream() {
        return get().stream();
    }

    public Set<Role> get() {
        return roles();
    }
}
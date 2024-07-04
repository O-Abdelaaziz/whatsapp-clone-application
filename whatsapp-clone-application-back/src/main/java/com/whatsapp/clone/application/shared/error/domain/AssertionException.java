package com.whatsapp.clone.application.shared.error.domain;

import java.util.Map;

/**
 * @Created 4/7/2024 - 12:37 PM on (Thursday)
 * @Package com.whatsapp.clone.application.shared.error.domain
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public abstract class AssertionException extends RuntimeException {

    private final String field;

    protected AssertionException(String field, String message) {
        super(message);
        this.field = field;
    }

    public abstract AssertionErrorType type();

    public String field() {
        return field;
    }

    public Map<String, String> parameters() {
        return Map.of();
    }
}

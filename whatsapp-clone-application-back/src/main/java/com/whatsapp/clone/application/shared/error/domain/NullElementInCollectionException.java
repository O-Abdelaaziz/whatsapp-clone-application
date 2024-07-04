package com.whatsapp.clone.application.shared.error.domain;

/**
 * @Created 4/7/2024 - 12:39 PM on (Thursday)
 * @Package com.whatsapp.clone.application.shared.error.domain
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public class NullElementInCollectionException extends AssertionException {

    public NullElementInCollectionException(String field) {
        super(field, message(field));
    }

    private static String message(String field) {
        return new StringBuilder().append("The field \"").append(field).append("\" contains a null element").toString();
    }

    @Override
    public AssertionErrorType type() {
        return AssertionErrorType.NULL_ELEMENT_IN_COLLECTION;
    }
}

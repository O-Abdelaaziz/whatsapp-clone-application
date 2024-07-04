package com.whatsapp.clone.application.shared.error.domain;

/**
 * @Created 4/7/2024 - 12:36 PM on (Thursday)
 * @Package com.whatsapp.clone.application.shared.error.domain
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public enum AssertionErrorType {
    MISSING_MANDATORY_VALUE,
    NOT_AFTER_TIME,
    NOT_BEFORE_TIME,
    NULL_ELEMENT_IN_COLLECTION,
    NUMBER_VALUE_TOO_HIGH,
    NUMBER_VALUE_TOO_LOW,
    STRING_TOO_LONG,
    STRING_TOO_SHORT,
    TOO_MANY_ELEMENTS,
}

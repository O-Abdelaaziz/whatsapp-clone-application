package com.whatsapp.clone.application.shared.service;

/**
 * @Created 4/7/2024 - 12:29 PM on (Thursday)
 * @Package com.whatsapp.clone.application.shared.service
 * @Project whatsapp-clone-application-back
 * @User mrabdelaaziz
 * @Author Abdelaaziz Ouakala
 **/
public class StateBuilder<T, V> {
    private StatusNotification status;
    private T value;
    private V error;

    public State<T, V> forError(V error) {
        this.error = error;
        this.status = StatusNotification.ERROR;
        return new State<>(this.status, this.value, this.error);
    }

    public State<T, V> forSuccess() {
        this.status = StatusNotification.OK;
        return new State<>(this.status, this.value, this.error);
    }

    public State<T, V> forSuccess(T value) {
        this.value = value;
        this.status = StatusNotification.OK;
        return new State<>(this.status, this.value, this.error);
    }

    public State<T, V> forUnauthorized(V error) {
        this.error = error;
        this.status = StatusNotification.UNAUTHORIZED;
        return new State<>(this.status, this.value, this.error);
    }

}

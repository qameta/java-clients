package io.qameta.clients.commons.interceptor;

/**
 * @author vbragin
 */
public final class EmptyAuthInterceptor extends AuthInterceptor {

    public EmptyAuthInterceptor() {
        super("");
    }
}

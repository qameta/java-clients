package io.qameta.clients.commons.interceptor;

/**
 * Basic authenticator for okhttp client.
 */
public final class BasicAuthInterceptor extends AuthInterceptor {

    public BasicAuthInterceptor(final String username, final String password) {
        super(okhttp3.Credentials.basic(username, password));
    }
}

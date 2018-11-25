package io.qameta.clients.commons.interceptor;

import static java.lang.String.format;

/**
 * @author vbragin
 */
public final class TokenAuthInterceptor extends AuthInterceptor {

    public TokenAuthInterceptor(final String token) {
        super(format("Bearer %s", token));
    }
}

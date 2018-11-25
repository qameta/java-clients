package io.qameta.clients.commons.interceptor;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author vbragin
 */
public abstract class AuthInterceptor implements Interceptor {

    private static final String AUTHORIZATION_HEADER_NAME = "Authorization";

    private final String credentials;

    AuthInterceptor(final String credentials) {
        this.credentials = credentials;
    }

    @Override
    public Response intercept(final Interceptor.Chain chain) throws IOException {
        final Request request = chain.request();
        final Request authenticatedRequest = request.newBuilder()
                .header(AUTHORIZATION_HEADER_NAME, credentials).build();
        return chain.proceed(authenticatedRequest);
    }
}

package io.qameta.clients.bintray;

import io.qameta.clients.commons.retrofit.ServiceBuilder;

import static io.qameta.clients.commons.util.PropertyUtils.requireProperty;

/**
 * Bintray Service builder.
 */
public class BintrayServiceBuilder extends ServiceBuilder {

    private static final String BINTRAY_ENDPOINT = "BINTRAY_ENDPOINT";
    private static final String BINTRAY_USERNAME = "BINTRAY_USERNAME";
    private static final String BINTRAY_PASSWORD = "BINTRAY_PASSWORD";

    @Override
    public BintrayServiceBuilder endpoint(final String endpoint) {
        super.endpoint(endpoint);
        return this;
    }

    @Override
    public BintrayServiceBuilder username(final String username) {
        super.username(username);
        return this;
    }

    @Override
    public BintrayServiceBuilder password(final String password) {
        super.password(password);
        return this;
    }

    @Override
    public BintrayServiceBuilder defaults() {
        endpoint(requireProperty(BINTRAY_ENDPOINT));
        username(requireProperty(BINTRAY_USERNAME));
        password(requireProperty(BINTRAY_PASSWORD));
        return this;
    }

    public BintrayApi build() {
        return getRetrofit().create(BintrayApi.class);
    }

    public BintrayDl buildDl() {
        return getRetrofit().create(BintrayDl.class);
    }
}

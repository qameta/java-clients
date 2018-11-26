package io.qameta.clients.wrike;

import io.qameta.clients.commons.retrofit.ServiceBuilder;

import static io.qameta.clients.commons.util.PropertyUtils.requireProperty;

/**
 * Wrike Service builder.
 */
public class WrikeServiceBuilder extends ServiceBuilder {

    private static final String WRIKE_ENDPOINT = "WRIKE_ENDPOINT";
    private static final String WRIKE_TOKEN = "WRIKE_TOKEN";

    @Override
    public WrikeServiceBuilder endpoint(final String endpoint) {
        super.endpoint(endpoint);
        return this;
    }

    @Override
    public WrikeServiceBuilder token(final String token) {
        super.token(token);
        return this;
    }

    @Override
    public WrikeServiceBuilder defaults() {
        endpoint(requireProperty(WRIKE_ENDPOINT));
        token(requireProperty(WRIKE_TOKEN));
        return this;
    }

    public WrikeApi build() {
        return getRetrofit().create(WrikeApi.class);
    }
}

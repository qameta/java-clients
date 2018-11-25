package io.qameta.clients.github;

import io.qameta.clients.commons.retrofit.ServiceBuilder;

import static io.qameta.clients.commons.util.PropertyUtils.requireProperty;

/**
 * Jira Service builder.
 */
public class GithubServiceBuilder extends ServiceBuilder {

    private static final String GITHUB_ENDPOINT = "GITHUB_ENDPOINT";

    @Override
    public GithubServiceBuilder endpoint(final String endpoint) {
        super.endpoint(endpoint);
        return this;
    }

    @Override
    public GithubServiceBuilder username(final String username) {
        super.username(username);
        return this;
    }

    @Override
    public GithubServiceBuilder password(final String password) {
        super.password(password);
        return this;
    }

    @Override
    public GithubServiceBuilder token(final String token) {
        super.token(token);
        return this;
    }

    @Override
    public GithubServiceBuilder defaults() {
        endpoint(requireProperty(GITHUB_ENDPOINT));
        return this;
    }

    public GithubApi build() {
        return getRetrofit().create(GithubApi.class);
    }
}

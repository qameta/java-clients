package io.qameta.clients.jira;

import io.qameta.clients.commons.retrofit.ServiceBuilder;
import static io.qameta.clients.commons.util.PropertyUtils.requireProperty;

/**
 * Jira Service builder.
 */
public class JiraServiceBuilder extends ServiceBuilder {

    private static final String JIRA_ENDPOINT = "JIRA_ENDPOINT";
    private static final String JIRA_USERNAME = "JIRA_USERNAME";
    private static final String JIRA_PASSWORD = "JIRA_PASSWORD";

    @Override
    public JiraServiceBuilder endpoint(final String endpoint) {
        super.endpoint(endpoint);
        return this;
    }

    @Override
    public JiraServiceBuilder username(final String username) {
        super.username(username);
        return this;
    }

    @Override
    public JiraServiceBuilder password(final String password) {
        super.password(password);
        return this;
    }

    @Override
    public JiraServiceBuilder defaults() {
        endpoint(requireProperty(JIRA_ENDPOINT));
        username(requireProperty(JIRA_USERNAME));
        password(requireProperty(JIRA_PASSWORD));
        return this;
    }

    public JiraApi build() {
        return getRetrofit().create(JiraApi.class);
    }
}

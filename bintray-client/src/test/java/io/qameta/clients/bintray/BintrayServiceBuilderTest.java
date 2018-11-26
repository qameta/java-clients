package io.qameta.clients.bintray;

import io.qameta.clients.bintray.model.Repository;
import okhttp3.ResponseBody;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.EnvironmentVariables;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author charlie (Dmitry Baev).
 */
public class BintrayServiceBuilderTest {

    public static final String ENDPOINT = "https://api.bintray.com/";

    public static final String DL_ENDPOINT = "https://dl.bintray.com/";

    private static final String USERNAME = "**un**";

    private static final String PASSWORD = "**api_key**";

    @Rule
    public final EnvironmentVariables bintrayVariables = new EnvironmentVariables()
            .set("BINTRAY_ENDPOINT", ENDPOINT)
            .set("BINTRAY_USERNAME", USERNAME)
            .set("BINTRAY_PASSWORD", PASSWORD);

    @Test
    @Ignore
    public void shouldCallApi() {

        final BintrayApi api = new BintrayServiceBuilder().defaults().build();

        List<Repository> repositories = api.getRepositories("qameta");

        assertThat(repositories)
                .extracting(Repository::getName)
                .containsExactlyInAnyOrder("generic","maven-unstable","maven");

    }

    @Test
    @Ignore
    public void shouldCallDl() {

        final BintrayDl dl = new BintrayServiceBuilder().defaults().endpoint(DL_ENDPOINT).buildDl();

        ResponseBody body = dl.downloadFile("qameta", "maven", "io/qameta/allure/allure-jira/1.2.0/allure-jira-1.2.0.jar");

        assertThat(body.contentLength())
                .isGreaterThan(0l);
    }
}
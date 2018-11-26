package io.qameta.clients.jira;

import io.qameta.clients.jira.model.JiraIssue;
import io.qameta.clients.jira.model.JiraIssueComment;
import io.qameta.clients.jira.model.JiraTestResult;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.EnvironmentVariables;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author charlie (Dmitry Baev).
 */
public class JiraServiceBuilderTest {

    public static final String ENDPOINT = "http://localhost:2990/jira/rest";

    private static final String USERNAME = "admin";

    private static final String PASSWORD = "admin";

    @Rule
    public final EnvironmentVariables bintrayVariables = new EnvironmentVariables()
            .set("JIRA_ENDPOINT", ENDPOINT)
            .set("JIRA_USERNAME", USERNAME)
            .set("JIRA_PASSWORD", PASSWORD);

    @Test
    @Ignore
    public void shouldCall() {
        final JiraApi api = new JiraServiceBuilder().defaults().build();
        JiraIssue issue = api.getIssue("TEST-1");
        assertThat(issue).isNotNull();
    }

    @Test
    @Ignore
    public void shouldAddComment() {
        final JiraApi api = new JiraServiceBuilder().defaults().build();
        JiraIssueComment comment = new JiraIssueComment().setBody("new comment2");
        JiraIssueComment newComment = api.createIssueComment("TEST-2", comment);
        System.out.println(newComment);
        assertThat(newComment).extracting(JiraIssueComment::getBody).containsExactly(comment.getBody());
    }

    @Test
    @Ignore
    public void shouldGetTestResults() {
        final JiraApi api = new JiraServiceBuilder().defaults().build();

        JiraTestResult testResult = new JiraTestResult()
                .setName("testResult#15")
                .setIssueKeys(Collections.singletonList("TEST-3"))
                .setLaunchId(1)
                .setDate(1522057094865l)
                .setUrl("https://ci.qameta.io/job/allure2/job/master/Demo2_Report/index.html#suites/87ad0976b68c930eab55b5838ac4b46e/5beaaa6c18df6f26/")
                .setStatus("passed");

        JiraTestResult newTestResult = api.createTestResult(testResult);

        assertThat(newTestResult).extracting(JiraTestResult::getName).containsExactly(testResult.getName());

        List<JiraTestResult> testResults = api.getTestResults("TEST-3");
        assertThat(testResults).containsExactlyInAnyOrder(newTestResult);
    }
}
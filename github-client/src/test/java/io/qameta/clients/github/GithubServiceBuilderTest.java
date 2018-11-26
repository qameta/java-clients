package io.qameta.clients.github;

import io.qameta.clients.github.model.GithubIssue;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.EnvironmentVariables;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author charlie (Dmitry Baev).
 */
public class GithubServiceBuilderTest {

    private static final String ENDPOINT =  "https://api.github.com/";

    @Rule
    public final EnvironmentVariables jiraEnabled = new EnvironmentVariables()
            .set("GITHUB_ENDPOINT", ENDPOINT);

    @Test
    public void shouldCallWithDefault() {
        final Pattern compile = Pattern.compile("^([^/]+)/([^#]+)#(.+)$");
        final Matcher matcher = compile.matcher("allure-framework/allure2#845");
        System.out.println(matcher.matches());
        final String owner = matcher.group(1);
        System.out.println(owner);
        final String repo = matcher.group(2);
        System.out.println(repo);
        final String number = matcher.group(3);
        System.out.println(number);

        final GithubApi api = new GithubServiceBuilder().defaults().build();
        final GithubIssue issue = api.getIssue(owner, repo, number);

        System.out.println(issue);
    }

    @Test
    public void shouldCallWithEndpoint() {
        final Pattern compile = Pattern.compile("^([^/]+)/([^#]+)#(.+)$");
        final Matcher matcher = compile.matcher("allure-framework/allure2#845");
        System.out.println(matcher.matches());
        final String owner = matcher.group(1);
        System.out.println(owner);
        final String repo = matcher.group(2);
        System.out.println(repo);
        final String number = matcher.group(3);
        System.out.println(number);

        final GithubApi api = new GithubServiceBuilder().endpoint(ENDPOINT).build();
        final GithubIssue issue = api.getIssue(owner, repo, number);

        System.out.println(issue);
    }
}
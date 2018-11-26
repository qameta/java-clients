package io.qameta.clients.github;

import io.qameta.clients.github.model.GithubIssue;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author charlie (Dmitry Baev).
 */
public interface GithubApi {

    /**
     * Returns the Github issue by provided number.
     */
    @GET("repos/{owner}/{repo}/issues/{number}")
    GithubIssue getIssue(
            @Path("owner") String owner,
            @Path("repo") String repo,
            @Path("number") String number
    );
}

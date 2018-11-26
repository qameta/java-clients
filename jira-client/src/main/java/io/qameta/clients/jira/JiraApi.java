package io.qameta.clients.jira;

import io.qameta.clients.jira.model.JiraIssue;
import io.qameta.clients.jira.model.JiraIssueComment;
import io.qameta.clients.jira.model.JiraLaunch;
import io.qameta.clients.jira.model.JiraTestResult;
import io.qameta.clients.jira.model.XrayTestRun;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

/**
 * Jira Service declaration.
 */
public interface JiraApi {

    /**
     * Returns the Jira issue by provided key.
     */
    @GET("api/2/issue/{key}")
    JiraIssue getIssue(@Path("key") String key);

    @POST("api/2/issue/{issueKey}/comment")
    JiraIssueComment createIssueComment(@Path("issueKey") String issueKey,
                                    @Body JiraIssueComment comment);

    @POST("allure/1.0/launch")
    JiraLaunch createJiraLaunch(@Body JiraLaunch launch);

    @GET("allure/1.0/launch")
    List<JiraLaunch> getJiraLaunches(@Query("issueKey") String issueKey);

    @POST("allure/1.0/testresult")
    JiraTestResult createTestResult(@Body JiraTestResult launch);

    @GET("allure/1.0/testresult")
    List<JiraTestResult> getTestResults(@Query("issueKey") String issueKey);

    @GET("raven/1.0/api/testexec/{issueKey}/test")
    List<XrayTestRun> getTestRunsForTestExecution(@Path("issueKey") String issueKey);

    @PUT("raven/1.0/api/testrun/{id}/status")
    ResponseBody updateTestRunStatus(@Path("id") Integer id,
                                     @Query("status") String status);
}

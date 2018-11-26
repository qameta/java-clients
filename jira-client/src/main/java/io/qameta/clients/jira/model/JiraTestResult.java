package io.qameta.clients.jira.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Jira test result export data.
 */
@Data
@Accessors(chain = true)
public class JiraTestResult {

    private int id;

    private Integer launchId;
    private List<String> issueKeys;

    private String name;
    private String url;
    private Long date;

    private String status;
}

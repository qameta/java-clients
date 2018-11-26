package io.qameta.clients.jira.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Jira issue comment data.
 */
@Data
@Accessors(chain = true)
public class JiraIssueComment {

    private String body;
}

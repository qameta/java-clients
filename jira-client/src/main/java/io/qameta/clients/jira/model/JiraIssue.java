package io.qameta.clients.jira.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author charlie (Dmitry Baev).
 */
@Data
@Accessors(chain = true)
public class JiraIssue implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String key;

    protected Fields fields;

    public boolean isClosed() {
        return "done".equalsIgnoreCase(fields.getStatus().getName());
    }
}

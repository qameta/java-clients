package io.qameta.clients.github.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author charlie (Dmitry Baev).
 */
@Data
@Accessors(chain = true)
public class GithubIssue implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String title;
    protected Long number;
    protected String state;

    public boolean isClosed() {
        return "closed".equalsIgnoreCase(state);
    }
}

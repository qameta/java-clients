package io.qameta.clients.wrike.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author vbragin
 */
@Data
@Accessors(chain = true)
public class WrikeIssue implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String id;

    protected String title;

    protected String status;

    public boolean isClosed() {
        return "Completed".equalsIgnoreCase(status);
    }
}

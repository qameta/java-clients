package io.qameta.clients.wrike.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author vbragin
 */
@Data
@Accessors(chain = true)
@SuppressWarnings("PMD.UseVarargs")
public class Tasks implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String kind;

    protected WrikeIssue[] data;

    public WrikeIssue[] getData() {
        return Optional.ofNullable(data)
                .map(issues -> Arrays.copyOf(issues, issues.length))
                .orElse(null);
    }

    public void setData(final WrikeIssue[] data) {
        this.data = Optional.ofNullable(data)
                .map(issues -> Arrays.copyOf(issues, issues.length))
                .orElse(null);
    }
}

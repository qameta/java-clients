package io.qameta.clients.jira.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Xray test execution data.
 */
@Data
@Accessors(chain = true)
public class XrayTestRun {

    private int id;
    private String key;
    private String status;
}

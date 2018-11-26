package io.qameta.clients.jira.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author vbragin
 */
@Data
@Accessors(chain = true)
public class Fields implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String summary;

    protected Status status;
}

package io.qameta.clients.bintray.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author vbragin
 */
@Data
@Accessors(chain = true)
public class Repository {

    protected String name;

    protected String owner;

}

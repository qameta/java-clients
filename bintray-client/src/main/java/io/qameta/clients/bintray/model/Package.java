package io.qameta.clients.bintray.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author vbragin
 */
@Data
@Accessors(chain = true)
public class Package {

    protected String name;

    protected List<String> versions;
}

package io.qameta.clients.wrike;

import io.qameta.clients.wrike.model.Tasks;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.EnvironmentVariables;

/**
 * @author charlie (Dmitry Baev).
 */
public class WrikeServiceBuilderTest {

    private static final String ENDPOINT =  "https://www.wrike.com/api/v4";

    private static final String TOKEN = "***TOKEN***";
    @Rule
    public final EnvironmentVariables wrikeVariables = new EnvironmentVariables()
            .set("WRIKE_ENDPOINT", ENDPOINT)
            .set("WRIKE_TOKEN", TOKEN);
    @Test
    @Ignore
    public void shouldCall() {

        final WrikeApi api = new WrikeServiceBuilder().defaults().build();

        Tasks tasks = api.getTasks("TASK_ID");

        System.out.println(tasks);
    }
}
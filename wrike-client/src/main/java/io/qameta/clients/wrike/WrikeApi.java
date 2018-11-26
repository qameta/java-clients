package io.qameta.clients.wrike;

import io.qameta.clients.wrike.model.Tasks;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Wrike Service declaration.
 */
public interface WrikeApi {

    /**
     * Returns the Wrike tasks by provided number.
     */
    @GET("api/v4/tasks/{taskId}")
    Tasks getTasks(@Path("taskId") String taskId);
}

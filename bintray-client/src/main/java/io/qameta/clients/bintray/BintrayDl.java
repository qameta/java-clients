package io.qameta.clients.bintray;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author vbragin
 */
public interface BintrayDl {

    @GET("{subject}/{repo}/{path}")
    ResponseBody downloadFile(@Path("subject") String subject,
                              @Path("repo") String repo,
                              @Path("path") String path);
}

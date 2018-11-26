package io.qameta.clients.bintray;

import io.qameta.clients.bintray.model.File;
import io.qameta.clients.bintray.model.Repository;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * @author vbragin
 */
@SuppressWarnings("PMD.UseObjectForClearerAPI")
public interface BintrayApi {

    @GET("repos/{subject}")
    List<Repository> getRepositories(@Path("subject") String subject);

    @GET("repos/{subject}/{repo}/packages")
    List<Package> getRepositoryPackages(@Path("subject") String subject,
                                        @Path("repo") String repo);

    @GET("packages/{subject}/{repo}/{package}")
    Package getPackage(@Path("subject") String subject,
                       @Path("repo") String repo,
                       @Path("package") String productPackage);

    @GET("packages/{subject}/{repo}/{package}/files")
    List<File> getPackageFiles(@Path("subject") String subject,
                               @Path("repo") String repo,
                               @Path("package") String productPackage);

    @GET("packages/{subject}/{repo}/{package}/versions/{version}/files")
    List<File> getVersionFiles(@Path("subject") String subject,
                               @Path("repo") String repo,
                               @Path("package") String productPackage,
                               @Path("version") String version);

}

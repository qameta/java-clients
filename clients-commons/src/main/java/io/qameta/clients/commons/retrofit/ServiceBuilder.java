package io.qameta.clients.commons.retrofit;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.clients.commons.interceptor.AuthInterceptor;
import io.qameta.clients.commons.interceptor.BasicAuthInterceptor;
import io.qameta.clients.commons.interceptor.EmptyAuthInterceptor;
import io.qameta.clients.commons.interceptor.TokenAuthInterceptor;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

/**
 * @author vbragin
 */
@SuppressWarnings("PMD.AvoidFieldNameMatchingMethodName")
public abstract class ServiceBuilder {

    private String endpoint;
    private String token;
    private String username;
    private String password;

    protected ServiceBuilder endpoint(final String endpoint) {
        Objects.requireNonNull(endpoint);
        this.endpoint = addSlashIfMissing(endpoint);
        return this;
    }

    protected ServiceBuilder token(final String token) {
        Objects.requireNonNull(token);
        this.token = token;
        return this;
    }

    protected ServiceBuilder username(final String username) {
        Objects.requireNonNull(username);
        this.username = username;
        return this;
    }

    protected ServiceBuilder password(final String password) {
        Objects.requireNonNull(password);
        this.password = password;
        return this;
    }

    private static String addSlashIfMissing(final String endpoint) {
        final String slash = "/";
        return endpoint.endsWith(slash) ? endpoint : endpoint + slash;
    }

    private AuthInterceptor getAuthInterceptor() {
        if (StringUtils.isNotBlank(token)) {
            return new TokenAuthInterceptor(token);
        } else if (StringUtils.isNotBlank(username)
                && StringUtils.isNotBlank(password)) {
            return new BasicAuthInterceptor(username, password);
        }
        return new EmptyAuthInterceptor();
    }

    protected Retrofit getRetrofit() {
        final OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(getAuthInterceptor())
                .connectTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(5, TimeUnit.MINUTES)
                .readTimeout(10, TimeUnit.MINUTES)
                .build();

        return new Retrofit.Builder()
                .baseUrl(endpoint)
                .addConverterFactory(JacksonConverterFactory.create(
                        new ObjectMapper().disable(FAIL_ON_UNKNOWN_PROPERTIES)
                ))
                .addCallAdapterFactory(new DefaultCallAdapterFactory<>())
                .client(client)
                .build();
    }

    public abstract ServiceBuilder defaults();
}

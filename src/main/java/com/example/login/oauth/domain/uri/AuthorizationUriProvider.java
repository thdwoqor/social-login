package com.example.login.oauth.domain.uri;

public interface AuthorizationUriProvider {

    boolean supports(String providerName);
    String getUri();
}

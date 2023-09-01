package com.example.login.oauth.infra.google;

import com.example.login.oauth.domain.uri.AuthorizationUriProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class GoogleAuthorizationUriProviderProvider implements AuthorizationUriProvider {

    private final GoogleOAuthConfig googleOAuthConfig;

    @Override
    public boolean supports(final String providerName) {
        return googleOAuthConfig.getProviderName().equals(providerName);
    }

    @Override
    public String getUri() {
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("accounts.google.com")
                .path("/o/oauth2/v2/auth")
                .queryParam("scope", googleOAuthConfig.getScope())
                .queryParam("redirect_uri", googleOAuthConfig.getRedirectUri())
                .queryParam("response_type", "code")
                .queryParam("client_id", googleOAuthConfig.getClientId())
                .build()
                .toString();
    }
}

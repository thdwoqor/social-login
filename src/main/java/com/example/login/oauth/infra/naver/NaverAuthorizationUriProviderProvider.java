package com.example.login.oauth.infra.naver;

import com.example.login.oauth.domain.uri.AuthorizationUriProvider;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class NaverAuthorizationUriProviderProvider implements AuthorizationUriProvider {

    private final NaverOAuthConfig naverOAuthConfig;

    @Override
    public boolean supports(final String providerName) {
        return naverOAuthConfig.getProviderName().equals(providerName);
    }

    @Override
    public String getUri() {
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("nid.naver.com")
                .path("/oauth2.0/authorize")
                .queryParam("state", UUID.randomUUID())
                .queryParam("redirect_uri", naverOAuthConfig.getRedirectUri())
                .queryParam("response_type", "code")
                .queryParam("client_id", naverOAuthConfig.getClientId())
                .build()
                .toString();
    }
}

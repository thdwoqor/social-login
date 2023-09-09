package com.example.login.oauth.infra.naver;

import com.example.login.oauth.domain.client.OAuthClient;
import com.example.login.oauth.infra.dto.OAuthUserInfo;
import com.example.login.oauth.infra.naver.NaverUserInfoResponse.Response;
import com.example.login.oauth.infra.dto.OAuthCodeStateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Component
@RequiredArgsConstructor
public class NaverOAuthClient implements OAuthClient {

    private final NaverAccessTokenClient naverAccessTokenClient;
    private final NaverUserInfoClient naverUserInfoClient;
    private final NaverOAuthConfig naverOAuthConfig;

    @Override
    public boolean supports(final String providerName) {
        return naverOAuthConfig.getProviderName().equals(providerName);
    }

    @Override
    public String getAccessToken(final OAuthCodeStateDTO oauthCodeStateDTO) {
        MultiValueMap<String, String> param = new LinkedMultiValueMap();
        param.add("client_id", naverOAuthConfig.getClientId());
        param.add("client_secret", naverOAuthConfig.getClientSecret());
        param.add("grant_type", naverOAuthConfig.getGrantType());
        param.add("code", oauthCodeStateDTO.code());
        param.add("state", oauthCodeStateDTO.state());

        NaverAccessTokenResponse response = naverAccessTokenClient.getNaverToken(param);
        return response.getAccessToken();
    }

    @Override
    public OAuthUserInfo getUserInfo(final String accessToken) {
        Response response = naverUserInfoClient.getUserInfo("Bearer " + accessToken).getResponse();
        return OAuthUserInfo.builder()
                .id(response.getId())
                .email(response.getEmail())
                .nickname(response.getName())
                .build();
    }
}

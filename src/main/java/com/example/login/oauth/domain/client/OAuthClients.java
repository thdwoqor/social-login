package com.example.login.oauth.domain.client;

import com.example.login.oauth.infra.dto.OAuthUserInfo;
import com.example.login.oauth.service.OAuthInfoDto;
import com.example.login.oauth.infra.dto.OAuthCodeStateDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OAuthClients {

    private final List<OAuthClient> oauthClients;

    private OAuthClient getSocialAuthService(final String provider) {
        return oauthClients.stream()
                .filter(OAuthClient -> OAuthClient.supports(provider))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 소셜 로그인입니다."));
    }

    public OAuthUserInfo getUserInfo(final OAuthInfoDto oauthInfoDto) {
        OAuthCodeStateDTO oauthCodeStateDTO = new OAuthCodeStateDTO(
                oauthInfoDto.code(),
                oauthInfoDto.state()
        );

        OAuthClient oauthClient = getSocialAuthService(oauthInfoDto.provider());
        String accessToken = oauthClient.getAccessToken(oauthCodeStateDTO);
        return oauthClient.getUserInfo(accessToken);
    }
}

package com.example.login.oauth.service;

import com.example.login.oauth.domain.OAuthUser;
import com.example.login.oauth.domain.OAuthUserRepository;
import com.example.login.oauth.domain.client.OAuthClients;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuthService {

    private final OAuthClients oauthClients;
    private final OAuthUserRepository oauthUserRepository;

    public String doSocialLogin(final OAuthInfoDto oauthParam) {
        OAuthUser oauthUser = oauthClients.getUserInfo(oauthParam).toOAuthUser();

        Optional<OAuthUser> findSocialUser = oauthUserRepository.findByOauthId(oauthUser.getOauthId());

        OAuthUser oAuthUser = findSocialUser.orElseGet(() -> oauthUserRepository.save(oauthUser));

        return oAuthUser.getOauthId();
    }
}

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
    private final OAuthUserRepository OAuthUserRepository;

    public String doSocialLogin(String code, String provider) {
        OAuthUser OAuthUser = oauthClients.getUserInfo(code, provider).toOAuthUser();

        Optional<OAuthUser> findSocialUser = OAuthUserRepository.findByOauthId(OAuthUser.getOauthId());

        if (findSocialUser.isEmpty()) {
            OAuthUserRepository.save(OAuthUser);
        }

        return OAuthUser.getOauthId();
    }
}

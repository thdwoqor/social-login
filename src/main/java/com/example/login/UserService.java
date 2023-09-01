package com.example.login;

import com.example.login.auth.service.SocialAuthService;
import com.example.login.auth.service.SocialAuthServices;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final SocialAuthServices socialAuthServices;
    private final SocialUserRepository socialUserRepository;

    public String doSocialLogin(String code,String provider){
        SocialAuthService socialAuthService = socialAuthServices.getSocialAuthService(provider);

        String accessToken = socialAuthService.getAccessToken(code);
        SocialUser socialUser = socialAuthService.getUserInfo(accessToken);

        Optional<SocialUser> findSocialUser = socialUserRepository.findByProvideId(socialUser.getProvideId());

        if (findSocialUser.isEmpty()) {
            socialUserRepository.save(socialUser);
        }

        return socialUser.getProvideId();
    }
}

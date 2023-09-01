package com.example.login;

import com.example.login.auth.google.GoogleAccessTokenResponse;
import com.example.login.auth.google.GoogleUserInfoResponse;
import com.example.login.auth.kakao.KakaoAccessTokenResponse;
import com.example.login.auth.kakao.KakaoUserInfoResponse;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final GoogleLoginServiceImpl googleLoginServiceImpl;
    private final KakaoLoginServiceImpl kakaoLoginService;
    private final SocialUserRepository socialUserRepository;

    public String doGoogleLogin(String code) {
        GoogleAccessTokenResponse response = googleLoginServiceImpl.getAccessToken(code);
        GoogleUserInfoResponse userInfo = googleLoginServiceImpl.getUserInfo(response.getAccessToken());

        Optional<SocialUser> findSocialUser = socialUserRepository.findByProvideId(userInfo.getId());

        if (findSocialUser.isEmpty()) {
            socialUserRepository.save(userInfo.toSocialUser());
        }

        return userInfo.toSocialUser().getProvideId();
    }

    public String doKakaoLogin(String code) {
        KakaoAccessTokenResponse accessToken = kakaoLoginService.getAccessToken(code);
        KakaoUserInfoResponse userInfo = kakaoLoginService.getUserInfo(accessToken.getAccessToken());

        Optional<SocialUser> findSocialUser = socialUserRepository.findByProvideId(userInfo.getId());

        if (findSocialUser.isEmpty()) {
            socialUserRepository.save(userInfo.toSocialUser());
        }

        return userInfo.toSocialUser().getProvideId();
    }
}

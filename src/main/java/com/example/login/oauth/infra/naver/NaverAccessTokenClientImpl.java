package com.example.login.oauth.infra.naver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class NaverAccessTokenClientImpl {

//    @Bean
//    public NaverAccessTokenClient naverApiClient() {
//        WebClient webClient = WebClient.create();
//        HttpServiceProxyFactory build = HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient))
//                .build();
//        return build.createClient(NaverAccessTokenClient.class);
//    }

    @Bean
    public NaverAccessTokenClient naverApiClient() {
        RestClient restClient = RestClient.create();
        HttpServiceProxyFactory build = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient))
                .build();
        return build.createClient(NaverAccessTokenClient.class);
    }
}

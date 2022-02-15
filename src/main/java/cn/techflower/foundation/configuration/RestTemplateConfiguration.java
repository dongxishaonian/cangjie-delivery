package cn.techflower.foundation.configuration;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.protocol.HttpContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import java.net.URI;
import java.util.function.BiFunction;

@Configuration
@Slf4j
public class RestTemplateConfiguration {
    @Bean
    ClientHttpRequestFactory getClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();

        int connectTimeout = 5000;
        int readTimeout = 5000;

        clientHttpRequestFactory.setConnectTimeout(connectTimeout);
        clientHttpRequestFactory.setReadTimeout(readTimeout);
        clientHttpRequestFactory.setHttpContextFactory(new BiFunction<HttpMethod, URI, HttpContext>() {
            @Override
            public HttpContext apply(HttpMethod httpMethod, URI uri) {
                RequestConfig.Builder builder = RequestConfig.copy(RequestConfig.DEFAULT).setCookieSpec(CookieSpecs.STANDARD);
                HttpClientContext httpClientContext = new HttpClientContext();
                httpClientContext.setRequestConfig(builder.build());
                return httpClientContext;
            }
        });
        return clientHttpRequestFactory;
    }


}

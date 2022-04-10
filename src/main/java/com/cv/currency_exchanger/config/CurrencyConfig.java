package com.cv.currency_exchanger.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableCaching
@EnableScheduling
public class CurrencyConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

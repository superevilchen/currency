package com.cv.currency_exchanger.services;

import com.cv.currency_exchanger.beans.CurrencyRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExternalApiServiceImpl implements ExternalApiService{

    private final RestTemplate restTemplate;

    @Override
    @Cacheable(value="rates", key="#from")
    public CurrencyRequestDto getRate(String from) {

        log.info("new currency request pull from currency api {}", from);

        return restTemplate.getForObject("https://api.exchangerate-api.com/v4/latest/"+from.toUpperCase(), CurrencyRequestDto.class);
    }
}

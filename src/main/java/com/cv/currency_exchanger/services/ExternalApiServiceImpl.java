package com.cv.currency_exchanger.services;

import com.cv.currency_exchanger.beans.CurrencyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ExternalApiServiceImpl implements ExternalApiService{

    private final RestTemplate restTemplate;

    @Override
    @Cacheable(cacheNames="rates", key="#from")
    public CurrencyRequestDto getRate(String from) {

        long start = System.currentTimeMillis();

        CurrencyRequestDto result = restTemplate.getForObject("https://api.exchangerate-api.com/v4/latest/"+from.toUpperCase(), CurrencyRequestDto.class);

        long end = System.currentTimeMillis();
        System.out.println("total: " + (end-start) + " at: " + from);

        return result;
    }
}

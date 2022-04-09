package com.cv.currency_exchanger.services;

import com.cv.currency_exchanger.beans.CurrencyRequestDto;
import com.cv.currency_exchanger.beans.CurrencyResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@CacheConfig(cacheNames= "rates")
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final RestTemplate restTemplate;

    @Override
    public CurrencyResponseDto exchange(String fromCurrency, String toCurrency, double amount) {

        // add validation.. somehow

        CurrencyRequestDto fromCurrencyAll = restTemplate.getForObject("https://api.exchangerate-api.com/v4/latest/"+fromCurrency.toUpperCase(), CurrencyRequestDto.class);

        double result = fromCurrencyAll.getRates().get(toCurrency.toUpperCase()) * amount;

        return CurrencyResponseDto.builder()
                .fromCurrency(fromCurrency.toUpperCase())
                .toCurrency(toCurrency.toUpperCase())
                .amount(amount)
                .result(result)
                .build();
    }
}

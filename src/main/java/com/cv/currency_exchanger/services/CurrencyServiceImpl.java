package com.cv.currency_exchanger.services;

import com.cv.currency_exchanger.beans.CurrencyRequestDto;
import com.cv.currency_exchanger.beans.CurrencyResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final ExternalApiService externalApiService;

    @Override
    public CurrencyResponseDto exchange(String fromCurrency, String toCurrency, double amount) {

        // add validation.. somehow

        return CurrencyResponseDto.builder()
                .fromCurrency(fromCurrency.toUpperCase())
                .toCurrency(toCurrency.toUpperCase())
                .amount(amount)
                .result(externalApiService.getRate(fromCurrency).getRates().get(toCurrency.toUpperCase()) * amount)
                .build();
    }

//    @CacheEvict(condition = "date != today")

    // cachable(value="rates" key="rate#key")
    // public CurrencyRequestDto getRates (String key)
}

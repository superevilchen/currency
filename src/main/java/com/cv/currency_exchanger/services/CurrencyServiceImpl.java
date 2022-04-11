package com.cv.currency_exchanger.services;

import com.cv.currency_exchanger.beans.CurrencyRequestDto;
import com.cv.currency_exchanger.beans.CurrencyResponseDto;
import com.cv.currency_exchanger.exceptions.ExceptionState;
import com.cv.currency_exchanger.utils.Validators;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.cv.currency_exchanger.exceptions.ExceptionState.SUCCESS;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final ExternalApiService externalApiService;

    @Override
    public CurrencyResponseDto exchange(String fromCurrency, String toCurrency, double amount) {

//
//        if (!Validators.isAmountValid(amount).equals(SUCCESS) &&
//        !Validators.isCurrencyValid(fromCurrency).equals(SUCCESS) &&
//        !Validators.isCurrencyValid(toCurrency).equals(SUCCESS)) {
//            // throw specific exception with code!
//        }
        // add validation.. somehow

        return CurrencyResponseDto.builder()
                .fromCurrency(fromCurrency.toUpperCase())
                .toCurrency(toCurrency.toUpperCase())
                .amount(amount)
                .result(externalApiService.getRate(fromCurrency).getRates().get(toCurrency.toUpperCase()) * amount)
                .build();
    }
}

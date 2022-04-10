package com.cv.currency_exchanger.services;

import com.cv.currency_exchanger.beans.CurrencyRequestDto;

public interface ExternalApiService {

    CurrencyRequestDto getRate(String from);
}

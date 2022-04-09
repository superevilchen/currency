package com.cv.currency_exchanger.services;

import com.cv.currency_exchanger.beans.CurrencyResponseDto;

public interface CurrencyService {

    CurrencyResponseDto exchange(String fromCurrency, String toCurrency, double amount);
}

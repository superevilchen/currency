package com.cv.currency_exchanger.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyResponseDto {

    private String fromCurrency;
    private String toCurrency;
    private double amount;
    private double result;
}

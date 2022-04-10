package com.cv.currency_exchanger.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurrencyRequestDto {

    private Date date;
    private Map<String, Double> rates;
}

package com.cv.currency_exchanger.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurrencyRequestDto {

    private String provider;
    private String WARNING_UPGRADE_TO_V6;
    private String terms;
    private String base;
    private Date date;
    private long time_last_updated;
    private Map<String, Double> rates;
}

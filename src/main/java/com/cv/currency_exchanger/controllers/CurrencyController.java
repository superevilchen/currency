package com.cv.currency_exchanger.controllers;

import com.cv.currency_exchanger.beans.CurrencyResponseDto;
import com.cv.currency_exchanger.services.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/money/")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping("convert")
    public CurrencyResponseDto exchange(@RequestParam String from, @RequestParam String to, @RequestParam double amount){
        return currencyService.exchange(from, to, amount);
    }
}

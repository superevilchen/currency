package com.cv.currency_exchanger.bootstrap;

import com.cv.currency_exchanger.services.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CLR implements CommandLineRunner {

    private final CurrencyService currencyService;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(currencyService.exchange("USD", "ILS", 1));

    }
}

package com.cv.currency_exchanger.utils;

import com.cv.currency_exchanger.exceptions.ExceptionState;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static com.cv.currency_exchanger.exceptions.ExceptionState.*;

public class Validators {

    public static Map<String, Double> currencies;

    public static ExceptionState isAmountValid(double amount){
        return amount > 0 ? SUCCESS : INVALID_AMOUNT;
    }

    public static ExceptionState isCurrencyValid(String cur){
        if (cur.length() != 3){
            return INVALID_CURRENCY;
        }

        return currencies.containsKey(cur) ? SUCCESS : INVALID_CURRENCY;
    }
}

//    default ClientValidator and(ClientValidator other) {
//        return () -> {
//            ExceptionState result = this.get();
//            return result.equals(SUCCESS) ? other.get() : result;
//        };
//    }
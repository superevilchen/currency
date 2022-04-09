package com.cv.currency_exchanger.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class CurrencyControllerAdvice {

    @ExceptionHandler(value = {Exception.class}) // will catch exception
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiException handleError(Exception e){
        return new ApiException("something went wrong", e.getMessage());
    }

    @ExceptionHandler(RestClientException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND )
    public String handleNotFoundError(RestClientException ex) {
        return "path does not exists";
    }
}

package com.cv.currency_exchanger.jobs;

import com.cv.currency_exchanger.services.ExternalApiService;
import com.cv.currency_exchanger.utils.Validators;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class CacheDailyJobs {

    private final ExternalApiService externalApiService;
    private final CacheManager cacheManager;

    @Scheduled(cron = "0 0 6 * * *")
    public void clearCache() {
        cacheManager.getCache("rates").clear();
        log.info("cleared cache");

        Validators.currencies =  externalApiService.getRate("USD").getRates();
        log.info("reset total currencies for today {}", LocalDateTime.now());
    }
}

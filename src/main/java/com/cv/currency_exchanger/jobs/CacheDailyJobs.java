package com.cv.currency_exchanger.jobs;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CacheDailyJobs {

    private final CacheManager cacheManager;

    @Scheduled(cron = "0 0 6 * * *")
    public void clearCache() {
        cacheManager.getCache("rates").clear();
        log.info("cleared cache");
    }
}

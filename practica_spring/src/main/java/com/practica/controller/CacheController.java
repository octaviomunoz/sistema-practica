/* Si tienen problema con cache, lo descomentan.

package com.practica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CacheController {
    @Autowired
    private CacheManager cacheManager;

    @Scheduled(fixedRateString = "${clear.all.cache.fixed.rate}", initialDelayString = "${clear.all.cache.init.delay}") // reset cache every hr, with delay of 1hr after app start
    public void reportCurrentTime() {
        cacheManager.getCacheNames().parallelStream().forEach(name -> cacheManager.getCache(name).clear());
    }
}

*/
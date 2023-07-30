package com.nikhil.intuit.CraftDemo.service;

import lombok.extern.log4j.Log4j2;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicLong;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
@Log4j2
public class URLShortenerService {

    private final CuratorFramework curatorFramework;
    private Map<String, String> urlMap;
    private static final Logger logger = LogManager.getLogger(URLShortenerService.class);

    @Autowired
    public URLShortenerService(CuratorFramework curatorFramework) {
        this.curatorFramework = curatorFramework;
        this.urlMap = new HashMap<>();
        log.info("Added");
        logger.info("Adddeedddd");
    }

    @Async
    public CompletableFuture<String> shortenURL(String originalURL) throws Exception {
        String shortURL = generateShortURL();
        storeURLMapping(shortURL, originalURL);
        return CompletableFuture.completedFuture(shortURL);
    }

    private String generateShortURL() throws Exception {
        DistributedAtomicLong counter = new DistributedAtomicLong(curatorFramework, "/url-shortener/counter", null);
        counter.increment();
        return Long.toHexString(counter.get().postValue());
    }

    private void storeURLMapping(String shortURL, String originalURL) {
        urlMap.put(shortURL, originalURL);
    }

    public String getOriginalURL(String shortURL) {
        return urlMap.get(shortURL);
    }
}

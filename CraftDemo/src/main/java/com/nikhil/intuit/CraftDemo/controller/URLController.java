package com.nikhil.intuit.CraftDemo.controller;

import com.nikhil.intuit.CraftDemo.service.URLShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class URLController {
    private URLShortenerService urlShortenerService;

    @Autowired
    public URLController(URLShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping("/shorten")
    public CompletableFuture<String> shortenURL(@RequestBody String originalURL) throws Exception {
        return urlShortenerService.shortenURL(originalURL);
    }
}

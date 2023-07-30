package com.nikhil.intuit.CraftDemo.controller;

import com.nikhil.intuit.CraftDemo.service.URLShortenerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@Api(tags = "URL Shortener API")
public class URLController {
    private URLShortenerService urlShortenerService;

    @Autowired
    public URLController(URLShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping("/shorten")
    @ApiOperation("Generate Short URL")
    public CompletableFuture<String> shortenURL(@RequestBody String originalURL) throws Exception {
        return urlShortenerService.shortenURL(originalURL);
    }
    @GetMapping("/shorten2")
    @ApiOperation("Generate Short URL")
    public String getShortenURL() throws Exception {
        return "niks";//urlShortenerService.shortenURL(originalURL);
    }
}

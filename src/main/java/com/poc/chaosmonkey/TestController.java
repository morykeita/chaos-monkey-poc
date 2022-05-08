package com.poc.chaosmonkey;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TestController {

    private final CacheManager tokenCacheManager;
    private static String TOKEN_CACHE_NAME = "TOKEN_CACHE";


    @GetMapping
    public String saveToken(){
        String token = UUID.randomUUID().toString();
        tokenCacheManager.getCache(TOKEN_CACHE_NAME).put(token,token);
        return token;
    }
}

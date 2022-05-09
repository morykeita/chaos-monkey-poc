package com.poc.chaosmonkey;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TestController {

    private final CacheManager tokenCacheManager;
    private static String TOKEN_CACHE_NAME = "TOKEN_CACHE";

    @Autowired
    private TestService testService;

    @GetMapping
    @Retry(name = "throwingException")
    public String saveToken(){
        String token = UUID.randomUUID().toString();
        tokenCacheManager.getCache(TOKEN_CACHE_NAME).put(token,token);
        return token;
    }

//    @GetMapping
//    public List<String> hello(){
//        return Arrays.asList("Red","Blue","Green");
//    }
}

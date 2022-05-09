package com.poc.chaosmonkey;


import io.lettuce.core.RedisCommandTimeoutException;
import io.lettuce.core.RedisException;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.connection.PoolException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.ConnectException;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({PoolException.class})
    public ResponseEntity handle(PoolException e){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Redis PoolException exception");
    }

    @ExceptionHandler({ConnectException.class})
    public ResponseEntity handle(ConnectException e){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("ConnectException exception");
    }


    @ExceptionHandler({RedisException.class})
    public ResponseEntity handle(RedisException e){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("RedisException exception");
    }

    @ExceptionHandler({RedisCommandTimeoutException.class})
    public ResponseEntity handle(RedisCommandTimeoutException e){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("RedisCommandTimeoutException exception");
    }
}

//java.net.ConnectException
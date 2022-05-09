package com.poc.chaosmonkey;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TestService {

    public List<String> getColors(){
        return Arrays.asList("Red","Blue","Green");
    }
}

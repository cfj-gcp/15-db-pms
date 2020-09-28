package com.example.demo.cach;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DefaultCacheTests {
    @Autowired
    private DefaultCache  defaultCache;
    @Autowired
    private DefaultCache  defaultCache1;
    @Test
    void testDefaultCache(){
        System.out.println(defaultCache);
        System.out.println(defaultCache==defaultCache1);
    }
}

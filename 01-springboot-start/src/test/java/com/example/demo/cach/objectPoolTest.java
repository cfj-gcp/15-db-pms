package com.example.demo.cach;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class objectPoolTest {
    @Autowired
    private  objectPool objectPool;
    @Autowired
    private  objectPool objectPool1;
    @Test
    void objectPool(){
        System.out.println(objectPool==objectPool1);
    }
}

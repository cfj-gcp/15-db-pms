package com.example.demo.DI;

import org.springframework.stereotype.Component;

@Component("df")
public class Soft  implements  Cache{
    @Override
    public void name() {
        System.out.println("我是soft");
    }
}

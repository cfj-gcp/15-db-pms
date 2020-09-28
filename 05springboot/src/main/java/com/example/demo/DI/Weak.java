package com.example.demo.DI;

import org.springframework.stereotype.Component;

@Component
public class Weak  implements Cache{
    @Override
    public void name() {
        System.out.println("我是weak");
    }
}

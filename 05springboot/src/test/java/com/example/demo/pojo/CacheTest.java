package com.example.demo.pojo;

import com.example.demo.DI.Cache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CacheTest {
    @Autowired
    @Qualifier("df")//配合上面的注解使用
//    @Autowired：描述属性时:用于告诉spring框架按照属性赋值，如果
//    只有一个则直接赋值，有多个则需要根据属性名,也可以指定名字
    private Cache cache;

    @Test
    void testcase(){
        System.out.println(cache);
    }
}

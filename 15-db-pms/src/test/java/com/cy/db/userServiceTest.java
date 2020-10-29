package com.cy.db;

import com.cy.db.pojo.user;
import com.cy.db.service.userService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class userServiceTest {
    @Autowired
    private userService  userService;
    @Test
    void  userTest(){
        user user = new user();
        user.setPassword("123");
        user.setSalt("123");
        user.setCreatedTime(new Date());
        user.setDeptId(2);
        user.setEmail("1136@qq.com");
        user.setId(21);
        user.setMobile(null);
        user.setValid(0);
        user.setUsername("v588");
        user.setModifiedUser(null);
        Integer[] a={47,48};
        int i = userService.saveObjectUser(user, a);
        System.out.println(i);
    }
}

package com.cy.db;

import com.cy.db.Dao.userDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDao {
    @Autowired
    private userDao user;
    @Test
    void  userValidTest(){
        int i = user.validById(1, 0, null);
        System.out.println(i);
    }
}

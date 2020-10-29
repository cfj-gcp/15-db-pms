package com.cy.db;

import com.cy.db.Dao.userRoleDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class userRoleTest {
    @Autowired
    private userRoleDao userRole;
    @Test
    void  userRoleT(){
        Integer []  a={49,47};
        int i = userRole.insertObjects(88, a);
        System.out.println(i);
    }
}

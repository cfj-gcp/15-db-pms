package com.cy.db;

import com.cy.db.pojo.role;
import com.cy.db.pojo.page;
import com.cy.db.service.roleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class rolesServiceTest {
    @Autowired
    private roleService  roleService;
    @Test
    void  roleServiceTest(){
        page<role> s = roleService.findPageObject("软件",1);
        System.out.println(s);
    }
}

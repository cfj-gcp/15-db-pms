package com.cy.db;

import com.cy.db.pojo.log;
import com.cy.db.pojo.page;
import com.cy.db.service.logService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class logserviceTest {
    @Autowired
    private logService  logService;
    @Test
    public void testFindPageObject(){
        page<log> admin = logService.findPageObjects("admin", 1);
        System.out.println(admin);
    }

}

package com.cy.service;

import com.cy.common.service.mail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class mailServiceTest {
    @Autowired
    private mail mailService;
    @Test
    void  maileTest(){
        boolean  b = mailService.sendMail("晕了");
        System.out.println(b);
    }
}

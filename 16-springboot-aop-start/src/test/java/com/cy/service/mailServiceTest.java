package com.cy.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class mailServiceTest {
    @Autowired
    private mailService mailService;

    @Test
    void testSendMail() {
        boolean b = mailService.sendMail("大乌龟");
        System.out.println(b);
    }
}

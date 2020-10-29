package com.cy.common.service;

import org.springframework.stereotype.Service;

@Service
public class mailServiceImpl implements mail {
    @Override
    public boolean sendMail(String msg) {
        System.out.println("send+>"+msg);
        return false;
    }
}

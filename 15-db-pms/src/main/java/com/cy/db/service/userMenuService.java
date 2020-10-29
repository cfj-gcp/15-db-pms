package com.cy.db.service;

import com.cy.db.pojo.userMenu;

import java.util.List;

public interface userMenuService {
    List<userMenu>  findUserMenuByUserId(Integer id);
}

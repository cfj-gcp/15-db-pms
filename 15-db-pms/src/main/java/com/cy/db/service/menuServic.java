package com.cy.db.service;

import com.cy.db.pojo.leftMenu;
import com.cy.db.pojo.menu;
import com.cy.db.pojo.node;

import java.awt.*;
import java.util.List;
import java.util.Map;

public interface menuServic {
//    左侧菜单
    List<leftMenu> findUserMenusByUserId(Integer id);
    int  updateObject(menu entity);
    int  insertObject(menu entity);
    List<node> findZtreeMenuNodes();
    int deleteObject(Integer id);
    List<Map<String,Object>> findObject();
}

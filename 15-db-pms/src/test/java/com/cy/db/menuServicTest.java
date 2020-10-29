package com.cy.db;

import com.cy.db.pojo.leftMenu;
import com.cy.db.pojo.menu;
import com.cy.db.service.menuServic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class menuServicTest {
    @Autowired
    private menuServic menu;
    @Test
    void MenuServiceTest(){
        int i = menu.deleteObject(8);
        System.out.println(i);
    }
    @Test
    void insertMenuTest(){
        com.cy.db.pojo.menu m= new menu();
        m.setCreatedTime(new Date());
        m.setCreatedUser("����");
        m.setId(9527);
        m.setModifiedTime(new Date());
        m.setName("cfj");
        m.setNote("cfj");
        m.setParentId(8888);
        m.setPermission("vb87");
        m.setSort(1213);
        m.setUrl("�Ҵ���");
        m.setType(321);
        int i = menu.insertObject(m);
        System.out.println(i);
    }
    @Test
    void  leftMenusTest(){
        List<leftMenu> men = menu.findUserMenusByUserId(36);
        System.out.println(men);
    }
}

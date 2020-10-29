package com.cy.db;

import com.cy.db.Dao.rolesDao;
import com.cy.db.pojo.roleMenu;
import com.cy.db.pojo.role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class rolesDaoTest {
    @Autowired
    private   rolesDao  rolesDao;
//    @Test
//    void rolesDaoTest(){
//        String name = "软件";
//        System.out.println("=-");
//        System.out.println("count:" + rolesDao.getRoleCount(name));
//    }
//    @Test
//    void  rolesObjectTest(){
//        List<role>  m = rolesDao.findObject("软件", 1, 1);
//        System.out.println(m);
//    }
    @Test
    void rolesInsertTest(){
        role u = new role();
        u.setCreatedTime(new Date());
        u.setCreatedUser("CV战士");
        u.setId(99);
        u.setModifiedTime(new Date());
        u.setModifiedUser("cv");
        u.setName("天");
        u.setNote("头晕");
        int i = rolesDao.insertObject(u);
        System.out.println(i);
    }
    @Test
    void  rolesFindById(){
        roleMenu menu = rolesDao.findObjectById(48);
        System.out.println(menu);
    }
    @Test
    void updateTest(){
        role u = new role();
        u.setCreatedTime(new Date());
        u.setCreatedUser(null);
        u.setId(50);
        u.setModifiedTime(new Date());
        u.setModifiedUser(null);
        u.setName("我康哥威武霸气");
        u.setNote("我佳哥霸气侧漏");
        int i = rolesDao.updateObject(u);
        System.out.println(i);
    }
}

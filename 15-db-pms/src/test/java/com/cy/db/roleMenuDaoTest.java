package com.cy.db;

import com.cy.db.Dao.RoleMenuDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class roleMenuDaoTest {
    @Autowired
    private RoleMenuDao  roleMenuDao;
    @Test
    void  roleMenuTest(){
         Integer [] a={555,666};
        int i = roleMenuDao.insertObjects(49,a);
        System.out.println(i);
    }
    @Test
    void role(){
        List<Integer> id = roleMenuDao.findByRoleId(48);
        System.out.println(id);
    }
    @Test
    void  testfindMenuIdsByRoleIds(){
        ArrayList<Integer> i = new ArrayList<>();
        i.add(49);
        i.add(447);
        List<Integer> is = roleMenuDao.findMenuIdsByRoleIds(i);
        System.out.println(is);
    }
}

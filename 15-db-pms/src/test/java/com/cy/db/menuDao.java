package com.cy.db;

import com.cy.db.Dao.MenuDao;
import com.cy.db.pojo.leftMenu;
import com.cy.db.pojo.menu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class menuDao {
    @Autowired
    private MenuDao menuDao;
    @Test
    void  testMenuDao(){
        List<Map<String, Object>> object = menuDao.findObject();
        for (Map<String, Object> map : object) {
            System.out.println(map);
        }
    }
    @Test
    void  testDeleteMenuDao(){
        int i = menuDao.deleteObject(148);
        System.out.println(i);
    }
    @Test
    void testIsert(){
        menu m= new menu();
        m.setCreatedTime(new Date());
        m.setCreatedUser("错了么");
        m.setId(9527);
        m.setModifiedTime(new Date());
        m.setName("cfj");
        m.setNote("cfj");
        m.setParentId(8888);
        m.setPermission("vb87");
        m.setSort(1213);
        m.setUrl("厉害了");
        m.setType(321);
        int i = menuDao.insertObject(m);
        System.out.println(i);
    }
    @Test
    void   testpermissions(){
        ArrayList<Integer> id = new ArrayList<>();
        id.add(8);
        id.add(25);
        List<String> list = menuDao.findpermissions(id);
        System.out.println(list);
    }
    @Test
    void  testLeftMenus(){
        ArrayList<Integer> i = new ArrayList<>();
         i.add(47);
         i.add(49);
        List<leftMenu> men = menuDao.findMenusByIds(i);
        System.out.println(men);
    }
}

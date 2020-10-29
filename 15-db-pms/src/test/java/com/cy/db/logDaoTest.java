package com.cy.db;

import com.cy.db.Dao.logDao;
import com.cy.db.pojo.log;
import lombok.Builder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class logDaoTest {
    @Autowired
    private logDao  logDao;
    @Test
    void  testInsert() {
        log l = new log();
        l.setCreatedTime(new Date());
        l.setTime(33l);
        l.setUsername("da");
        l.setIp("12.12.132");
        l.setMethod("dada");
        l.setParams("asfaf");
        l.setId(486551);
        l.setOperation("ffwfww");
        int i = logDao.insertObject(l);
        System.out.println(i);
    }
    @Test

    void testDeleteObjects(){
        int i = logDao.deleteObjects(11, 12, 13);
        System.out.println(i);
    }
    @Test
    public void testGetRowCount(){
        int rows = logDao.getRowCount("admin");
        System.out.println("row="+rows);
    }
    @Test
    public void testFindPageObject(){
        List<log> list = logDao.findPageObjects("admin", 0, 3);
//        for (logImpl log : list) {
//            System.out.println(log);
//        }
        list.forEach(log-> System.out.println(log));//lamda±Ì¥Ô Ωjdk1.8
    }
}

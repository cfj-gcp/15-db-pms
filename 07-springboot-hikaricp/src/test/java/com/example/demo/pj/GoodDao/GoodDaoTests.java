package com.example.demo.pj.GoodDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class GoodDaoTests {
    @Autowired
     private  GoodsDao goodsDao;
     @Test
    void testFindGoods() throws SQLException {
         List<Map<String,Object>>  list = goodsDao.findGoods();
         for (Map<String,Object> map:list){
             System.out.println(map);
         }
     }
}

package com.cy.pj.goods.dao;


import com.cy.pj.goods.pojo.Goods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GoodsDaoTest {
    @Autowired
    private  GoodsDao  goodsDao;
    @Test
    void testDeleteById(){
        int rows = goodsDao.deleteById(7);
        Assertions.assertEquals(1, rows);
    }
    @Test
    void  test(){
        List<Goods> goods = goodsDao.findGoods();
        for (Goods good : goods) {
            System.out.println(good);
        }
    }


}

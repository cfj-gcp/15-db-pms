package com.cy.pj.goods.dao;

import com.cy.pj.goods.pojo.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GoodsDaoTests {
     @Autowired
     @Qualifier("goodDaoImpl")
    private GoodsDao goodsDao;
    @Test
    void testFindGoods(){
        List<Goods> list = goodsDao.findGoods();
        for(Goods g:list){
            System.out.println(g);
        }
    }
}
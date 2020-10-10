package com.cy.pj.goods.dao;

import com.cy.pj.goods.pojo.Goods;
import com.cy.pj.goods.service.GoodsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GoodsServiceTest {
    @Autowired
    private GoodsService  goodsService;
    @Test
    void   test(){
        List<Goods> goods = goodsService.findGoods();
//        断言测试
        Assertions.assertEquals(true, goods.size()>0);
//        for (Goods good : goods) {
//            System.out.println(good);
//        }
    }
}

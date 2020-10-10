package com.cy.pj.goods.servic;

import com.cy.pj.goods.pojo.Goods;
import com.cy.pj.goods.service.GoodService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class GoodServiceTests {
    @Autowired
    private GoodService  goodService;
    @Test
    void testFindGoods(){
        List<Goods> list = goodService.findGoods();
        for (Goods goods : list) {
            System.out.println(goods);
        }
    }
}

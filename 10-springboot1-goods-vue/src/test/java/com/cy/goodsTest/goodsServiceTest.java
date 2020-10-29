package com.cy.goodsTest;

import com.cy.goods.pojo.Goods;
import com.cy.goods.service.GoodService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class goodsServiceTest {
    @Autowired
    private GoodService goodService;
    @Test
    void testService(){
        List<Goods> goods = goodService.selectAll();
        for (Goods good : goods) {
            System.out.println(good);
        }
    }
    @Test
    void testServiceDeleteById(){
        int i = goodService.deleteById(9);
        System.out.println(i);
    }
}

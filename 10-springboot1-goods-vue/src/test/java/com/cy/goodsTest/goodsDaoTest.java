package com.cy.goodsTest;

import com.cy.goods.dao.GoodsDao;
import com.cy.goods.pojo.Goods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

@SpringBootTest
public class goodsDaoTest {
    @Autowired
    private GoodsDao  goodsDao;
    @Test
    void  testGoodsDao(){
        List<Goods> goods = goodsDao.selectAll();
//        这里有两种方法测试写的持久层代码是否正确，这一种是打印出来
//        for (Goods good : goods) {
//            System.out.println(good);
//        }
//        还有一种断言测试,表示如果两者相等则程序继续执行，否则抛出异常
        Assertions.assertEquals(true, goods.size()>0);

    }
}

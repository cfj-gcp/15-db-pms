package com.cy.pj.goods.service;

import com.cy.pj.goods.dao.GoodsDao;
import com.cy.pj.goods.pojo.Goods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServicImpl  implements  GoodService{
     private  static  final Logger log=LoggerFactory.getLogger(GoodsServicImpl.class);
    @Autowired
    private GoodsDao goodsDao;
    @Override
    public List<Goods> findGoods() {
        long l = System.currentTimeMillis();
        List<Goods> list = goodsDao.findGoods();
        long l1 = System.currentTimeMillis();
//        System.out.println(l1-l);
        System.out.println(log.getClass().getName());
        log.info("findgoods()->l1-l={}",l1-l);
        return list;
    }
}

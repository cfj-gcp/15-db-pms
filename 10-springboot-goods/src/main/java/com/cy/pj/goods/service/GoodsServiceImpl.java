package com.cy.pj.goods.service;

import com.cy.pj.goods.dao.GoodsDao;
import com.cy.pj.goods.pojo.Goods;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class GoodsServiceImpl  implements  GoodsService{
//    private static final Logger log=LoggerFactory.getLogger(GoodsServiceImpl.class);
    @Autowired
    private GoodsDao  goodsDao;

    @Override
    public int saveGoods(Goods entity) {
        int row = goodsDao.insertObject(entity);
        return row;
    }

    @Override
    public int deleteById(Integer id) {
        long t1=System.currentTimeMillis();
        int rows=goodsDao.deleteById(id);
        long t2=System.currentTimeMillis();
        System.out.println("execute time:"+(t2-t1));
        return rows;
    }

    @Override
    public List<Goods> findGoods() {
        long t1=System.currentTimeMillis();
        List<Goods> list=goodsDao.findGoods();
        long t2=System.currentTimeMillis();
        log.info("findGoods()->t2-t1={}",t2-t1);//日志输出
        return list;
    }

    @Override
    public Goods findById(Integer id) {
        return goodsDao.findById(id);
    }

    @Override
    public int updateGoods(Goods goods) {
        return  goodsDao.updateGoods(goods);
    }
}

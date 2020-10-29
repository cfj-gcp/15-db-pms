package com.cy.goods.service;

import com.cy.goods.dao.GoodsDao;
import com.cy.goods.pojo.Goods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class serviceImpl  implements  GoodService {//实现业务层接口
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> selectAll() {
        List<Goods> goods = goodsDao.selectAll();
        return  goods;
    }

    @Override
    public int deleteById(Integer id) {
        long l = System.currentTimeMillis();
        int row = goodsDao.deleteById(id);
        long l1 = System.currentTimeMillis();
        long  l2=l1-l;
        log.info("deleteById()+>l1-l:"+l2);
        return row;
    }

    @Override
    public int insertObject(Goods entity) {
        int i = goodsDao.insertObject(entity);
        return i;
    }

    @Override
    public Goods findById(Integer id) {
        return goodsDao.findById(id);
    }

    @Override
    public int updateGoods(Goods goods) {
        int i = goodsDao.updateGoods(goods);
        return i;
    }
}

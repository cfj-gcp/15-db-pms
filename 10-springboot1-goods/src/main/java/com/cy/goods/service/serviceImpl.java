package com.cy.goods.service;

import com.cy.goods.dao.GoodsDao;
import com.cy.goods.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class serviceImpl  implements  GoodService {//实现业务层接口
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> selectAll() {
        List<Goods> goods = goodsDao.selectAll();
        return  goods;
    }
}

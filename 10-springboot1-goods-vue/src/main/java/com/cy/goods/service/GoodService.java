package com.cy.goods.service;

import com.cy.goods.pojo.Goods;

import java.util.List;

//定义业务层接口
public interface GoodService {
    List<Goods> selectAll();
    int deleteById(Integer id);
    int  insertObject(Goods entity);
    Goods findById(Integer id);
    int updateGoods(Goods goods);
}

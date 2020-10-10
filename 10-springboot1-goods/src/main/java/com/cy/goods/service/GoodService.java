package com.cy.goods.service;

import com.cy.goods.pojo.Goods;

import java.util.List;

//定义业务层接口
public interface GoodService {
    List<Goods> selectAll();
}

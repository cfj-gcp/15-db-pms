package com.cy.pj.goods.service;

import com.cy.pj.goods.pojo.Goods;

import java.util.List;

public interface GoodsService {
    int saveGoods(Goods entity);
    int deleteById(Integer id);
    List<Goods>  findGoods();
    Goods findById(Integer id);
    int  updateGoods(Goods goods);

}

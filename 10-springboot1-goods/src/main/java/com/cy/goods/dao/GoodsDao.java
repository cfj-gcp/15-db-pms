package com.cy.goods.dao;

import com.cy.goods.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper//此次注解表示自己不实现该接口交给框架来实现
public interface GoodsDao {
//    定义和数据库交互的接口
//    定义查询数据库的接口
    @Select("select * from tb_goods")
    List<Goods>  selectAll();

}

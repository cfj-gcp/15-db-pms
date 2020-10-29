package com.cy.goods.dao;

import com.cy.goods.pojo.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper//此次注解表示自己不实现该接口交给框架来实现
public interface GoodsDao {
//    定义和数据库交互的接口
//    定义查询数据库的接口
    @Select("select * from tb_goods")
    List<Goods>  selectAll();
//    定义删除数据库的接口
    @Delete("DELETE   FROM  tb_goods WHERE  id=#{id}")
    int deleteById(Integer id);
//    定义添加商品数据库的接口
    @Insert("insert into tb_goods(name,remark,createdTime) values (#{name},#{remark},now())")
    int  insertObject(Goods entity);
//定义根据Id更改商品接口
    @Select("select * from tb_goods where id=#{id}")
    Goods findById(Integer id);
    @Update("update tb_goods set name=#{name},remark=#{remark} where id=#{id}")
    int updateGoods(Goods goods);
}

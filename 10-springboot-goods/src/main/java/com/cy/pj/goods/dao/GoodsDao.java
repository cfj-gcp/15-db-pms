package com.cy.pj.goods.dao;

import com.cy.pj.goods.pojo.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper//这个注解的意思是自己不实现这个接口让底层帮我实现
public interface GoodsDao {
    @Update("update tb_goods set name=#{name},remark=#{remark} where id=#{id}")
    int updateGoods(Goods goods);
    @Select("select * from tb_goods where id=#{id}")
    Goods findById(Integer id);
   @Insert("insert into tb_goods(name,remark,createdTime)values (#{name},#{remark},now())")
    int insertObject(Goods entity);
    @Delete("delete from tb_goods where id=#{id}")
    int deleteById(Integer id);
//    mybatis框架中定义sql映射有两种方式
//    1.注解方式（简单sql语句映射）
//
@Select("select id,name,remark,createdTime from tb_goods")
    List<Goods> findGoods();
}

package com.cy.pj.goods.dao;

import com.cy.pj.goods.pojo.Goods;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodDaoImpl  implements  GoodsDao{

@Autowired
private SqlSessionFactory  sqlSessionFactory;
public  GoodDaoImpl(){
    System.out.println("我执行了");
}
    @Override
    public List<Goods> findGoods() {
        System.out.println("==findGoods()===");
        //1.获取SqlSession对象
        SqlSession session=sqlSessionFactory.openSession();
        //2.基于SqlSession实现商品查询
        String statement="com.cy.pj.goods.dao.GoodsDao.findGoods";//namespace+elementId
        List<Goods> list=session.selectList(statement);
        //3.释放资源
        session.close();
        //4.返回结果
        return list;

    }
}

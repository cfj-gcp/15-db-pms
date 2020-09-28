package com.example.demo.pj.GoodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 此对象为一个商品数据层访问对象,现在要求在此类中定义一个方法,这个方法基于JDBC从从数据库获取商品信息,
 * 并将其封装到map集合,要求一个行记录一个map对象(key为表中字段名,值为字段名对应的值),多个map存储到list集合.
 *
 * @Repository此注解通常用于描述数据层实现类对象,本质上就是一个特殊的@Component,
 * 都是要交给spring框架管理的一个Bean对象
 */
@Repository
public class GoodsDao implements  GoodDao {
    @Autowired
    private DataSource dataSource;//hikariCP
    /**查询商品信息,一行记录映射为内存中的一个map对象*/
    public List<Map<String,Object>> findGoods(){
        Connection conn=null;//java.sql.*
        Statement stmt=null;
        ResultSet rs=null;
        String sql="select * from tb_goods";
        //1.获取连接(从连接池获取)
        try {
            conn=dataSource.getConnection();
            //2.创建statement对象
            stmt=conn.createStatement();
            //3.发送sql
            rs=stmt.executeQuery(sql);
            //4.处理结果
            List<Map<String,Object>> list=new ArrayList<>();
            while(rs.next()){//循环一次取一行,一行记录映射为一个map对象
//                Map<String,Object> rowMap=new HashMap<>();
//                HashMap<String, Object> rowMap = new HashMap<>();
//                rowMap.put("id",rs.getInt("id"));
//                rowMap.put("name",rs.getString("name"));
//                rowMap.put("remark",rs.getString("remark"));
//                rowMap.put("createdTime",rs.getTimestamp("createdTime"));
//                list.add(rowMap);//将存储了一行记录的map对象再存储到list集合
                list.add(rowMap(rs));//将存储了一行记录的map对象在存储到list集合中
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);//转换为非检查异常(编译时不检测的异常)
        }finally{
            //5. 释放资源
            close(rs, stmt, conn);
//
        }
    }
    private  Map<String,Object> rowMap(ResultSet rs) throws SQLException {
        Map<String,Object>  rowmap=new HashMap<>();
        ResultSetMetaData metaData = rs.getMetaData();//获取元数据包括表中的字段名
        int columnCount = metaData.getColumnCount();//获取列数量
        for (int i = 0; i <columnCount ; i++) {
            rowmap.put(metaData.getColumnLabel(i+1), rs.getObject(metaData.getColumnLabel(i+1)));
//            getcolumnlablel(i+1)；获取表中字段名或者字段名对应的别名
        }
        return rowmap;
    }
    private  void close(ResultSet rs,Statement stmt,Connection conn){
        if(rs!=null)try{rs.close();}catch(Exception e){e.printStackTrace();}
           if(stmt!=null)try{stmt.close();}catch(Exception e){e.printStackTrace();}
           //这里的连接是返回到了池中
           if(conn!=null)try{conn.close();}catch(Exception e){e.printStackTrace();}
    }
}



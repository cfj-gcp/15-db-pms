package com.cy.db.Dao;

import com.cy.db.pojo.log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface logDao {
//    插入日志
    int insertObject(log entity);
//    基于id执行删除操作
    int deleteObjects(Integer... ids);
    int getRowCount(@Param("username") String username);
    List<log> findPageObjects(@Param("username")String username, @Param("startIndex")Integer startIndex, @Param("pageSize")Integer pageSize);
}

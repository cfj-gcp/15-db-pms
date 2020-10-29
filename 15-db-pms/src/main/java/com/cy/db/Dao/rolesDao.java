package com.cy.db.Dao;

import com.cy.db.pojo.roleMenu;
import com.cy.db.pojo.role;
import com.cy.db.pojo.userRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface rolesDao {
//    用户角色
    @Select("select id ,name from sys_roles")
    List<userRole>  finduserRoles();
//    更新数据
int updateObject(role entity);
//    根据角色id查询
//    @Select("select id,name,note from sys_roles where id=#{id}")
    roleMenu findObjectById(Integer id);
//   插入角色信息
    int insertObject(role entity);
//    按条件查询角色记录总数
    /**
     * 基于条件查询角色信息
     * @param name
     * @return
     */
//    int getRoleCount(@Param("name") String name);还是需要的换一种方法
//    查询数据
//   List<role> findObject(@Param("name") String name,还是需要的换一种方法
//                          @Param("startIndex")Integer startIndex,
//                          @Param("pageSize") Integer pageSize);

    List<role> findObject(String name);
}

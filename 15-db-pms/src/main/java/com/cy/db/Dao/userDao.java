package com.cy.db.Dao;

import com.cy.db.pojo.SysDept;
import com.cy.db.pojo.user;
import com.cy.db.pojo.userDept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface userDao {

//   登录认证    根据用户名获取对象的方法
    @Select("select * from sys_users where username=#{username}")
    user  findUserByUserName(String username);
//    修改用户密码信息
int updatePassword(
        @Param("password")String password,
        @Param("salt")String salt,
        @Param("id")Integer id);
//    更新user
int updateObject(user entity);
//根据id查询用户信息
    userDept  findObjectById(Integer id);
//    添加user
    int insertObject(user entity);
//    修改用户的状态信息
    int validById(@Param("id") Integer id,
                  @Param("valid")Integer valid,@Param("modifiedUser")String modifiedUser);
//    用户分页查询
    int getRowCount(String username);
    List<userDept> findPageObjects(String username,
                                   Integer startIndex,Integer pageSize);
}

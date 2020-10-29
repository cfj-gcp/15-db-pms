package com.cy.db.Dao;

import com.cy.db.pojo.userMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface userMenuDao {
    /**
     * 基于菜单获取菜单信息
     * @param menuIds
     * @return
     */
    List<userMenu>  findMenuById(@Param("menuIds")List<Integer> menuIds);
}

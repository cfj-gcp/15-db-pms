package com.cy.db.service.impl;

import com.cy.db.Dao.MenuDao;
import com.cy.db.Dao.RoleMenuDao;
import com.cy.db.Dao.userRoleDao;
import com.cy.db.common.annotation.RequiredLog;
import com.cy.db.common.exception.serviceException;
import com.cy.db.pojo.leftMenu;
import com.cy.db.pojo.menu;
import com.cy.db.pojo.node;
import com.cy.db.service.menuServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.Map;
@Service
public class menuImpl  implements menuServic {
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private RoleMenuDao roleMenuDao;
@Autowired
private userRoleDao  userRoleDao;
//左侧菜单
    @Override
    public List<leftMenu> findUserMenusByUserId(Integer id) {
        //1.对用户id进行判断
        //2.基于用户id查找用户对应的角色id
        List<Integer> roleIds=
                userRoleDao.findRoleByUserId(id);
        //3.基于角色id获取角色对应的菜单信息,并进行封装.
        List<Integer> menuIds=
                roleMenuDao.findMenuIdsByRoleIds(roleIds);
        //4.基于菜单id获取用户对应的菜单信息并返回
        return menuDao.findMenusByIds(menuIds);
    }

    //菜单的更新
    @Override
    public int updateObject(menu entity) {
//        1.合法验证
        if(entity==null)
            throw  new serviceException("保存对象不能为空");
        if(StringUtils.isEmpty(entity.getName()))
            throw  new serviceException("菜单名不能为空");
//        更新数据
        int i = menuDao.updateObject(entity);
        if(i==0)
            throw new serviceException("记录可能已经存在");
        return i;
    }

    //插入菜单
    @Override
    public int insertObject(menu entity) {
//        1.参数校验
        if(entity==null)
            throw  new IllegalArgumentException("保存对象不能为空");
        if(StringUtils.isEmpty(entity.getName()))
            throw  new serviceException("菜单名不能为空");
//        2.保存数据
        int i = menuDao.insertObject(entity);
        return i;
    }
//显示上级菜单
    @Override
    public List<node> findZtreeMenuNodes() {
        return menuDao.findZtreeMenuNodes();
    }

    @CacheEvict(value="menuCache",allEntries = true,beforeInvocation = false)
    @Override
    public int deleteObject(Integer id) {
//参数校验
        if(id==null||id<1) throw  new IllegalArgumentException("id值无效");
//   判定菜单是否有子菜单，有则不允许删除
        int childCount = menuDao.getChildCount(id);
        if(childCount>0) throw  new serviceException("请删除子表");
//删除关系数据
        roleMenuDao.deleteObjectByMenuId(id);
        int i = menuDao.deleteObject(id);
//        删除自身信息
        if(i==0)
            throw  new serviceException("记录可能已经不存在");
            return i;
    }

    @Cacheable(value="menuCache")
//    @RequiredLog("查询菜单")
    @Override
    public List<Map<String, Object>> findObject() {
        System.out.println("menu.findObject()");
        List<Map<String, Object>> mapList = menuDao.findObject();
        return mapList;
    }
}

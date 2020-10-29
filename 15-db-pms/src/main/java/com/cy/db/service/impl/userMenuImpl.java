package com.cy.db.service.impl;

import com.cy.db.Dao.RoleMenuDao;
import com.cy.db.Dao.userMenuDao;
import com.cy.db.Dao.userRoleDao;
import com.cy.db.pojo.userMenu;
import com.cy.db.service.userMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class userMenuImpl  implements userMenuService {
@Autowired
private userMenuDao   menu;
@Autowired
private userRoleDao    role;
@Autowired
private RoleMenuDao   roleMenu;
    @Override
    public List<userMenu> findUserMenuByUserId(Integer id) {
//        根据用户id查出用户权限id
        List<Integer> roleIds = role.findRoleByUserId(id);
//        根据权限id查询对应的菜单id
        List<Integer>  m= roleMenu.findByRoleId(id);
//        根据菜单id查询子菜单信息
        List<userMenu> menuById = menu.findMenuById(m);
        return   menuById;
    }
}

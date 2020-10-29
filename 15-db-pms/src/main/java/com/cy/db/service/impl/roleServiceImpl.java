package com.cy.db.service.impl;
import com.cy.db.Dao.RoleMenuDao;
import com.cy.db.Dao.rolesDao;
import com.cy.db.common.until.ValidUitls;
import com.cy.db.pojo.page;
import com.cy.db.pojo.roleMenu;
import com.cy.db.pojo.role;
import com.cy.db.pojo.userRole;
import com.cy.db.service.roleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;
@Service
public class roleServiceImpl implements roleService {
    @Autowired
    private rolesDao ro;
    @Autowired
    private RoleMenuDao roleMenuDao;
//用户权限
    @Override
    public List<userRole> findUserRole() {
        return  ro.finduserRoles() ;
    }
//修改权限
    @Override
    public int updateObject(role entity, Integer[] menuIds) {
//        1.合法性验证
        ValidUitls.isArgsValid(entity==null, "更新的对象不能为空");
        ValidUitls.isArgsValid(entity.getId()==null, "id的值不能为空");
        ValidUitls.isArgsValid(StringUtils.isEmpty(entity.getName()), "角色名不能空");
        ValidUitls.isArgsValid(menuIds==null, "必须给角色指定一个权限");
//        更新数据
        int i = ro.updateObject(entity);
        ValidUitls.isResultValid(i==0, "对象可能已经不存在");
        roleMenuDao.deleteObjectByRoleId(entity.getId());
        roleMenuDao.insertObjects(entity.getId(), menuIds);
        return i;
    }

    //修改角色以及对应的权限menu，先查出id对应的数据
    @Override
    public roleMenu findById(Integer id) {
//        校验
        ValidUitls.isArgsValid(id==null||id<1, "id值不合法");
//        执行查询
        roleMenu result = ro.findObjectById(id);
        ValidUitls.isResultValid(result==null, "记录可能不存在");
        return result;
    }

    //角色保存和对应的权限menu表
    @Override
    public int saveObject(role entity, Integer[] menuIds) {
//        参数校验
        ValidUitls.isArgsValid(entity==null, "保存对象不能为空");
         ValidUitls.isArgsValid(StringUtils.isEmpty(entity.getName()), "角色不能为空");
         ValidUitls.isResultValid(menuIds==null, "角色必须分配权限");
//         保存角色信息
        int i = ro.insertObject(entity);
//        保存角色权限菜单关系数据
        int row= roleMenuDao.insertObjects(entity.getId(), menuIds);
        return i;
    }

    @Override
    public page<role> findPageObject(String name, Integer pageCurrent) {
//           1.对参数进行校验
//        if(pageCurrent==null||pageCurrent<1)
//            throw  new IllegalArgumentException("当前页码值无效");
        ValidUitls.isArgsValid(pageCurrent==null||pageCurrent<1, "当前页码值不正确");
//        查询总记录数并进行校验
//        int rowCount = ro.getRoleCount(name);还是需要的换一种方法
//        if(rowCount==0)
//            throw new serviceException("没有知道对应的记录");
//        ValidUitls.isResultValid(rowCount==0,"没有找到对应记录");
//        3.查询当前页记录
        int pageSize=3;
//        int  startIndex=(pageCurrent-1)*pageSize;
       Page<role>  page=PageHelper.startPage(pageCurrent, pageSize);
        List<role> records = ro.findObject(name);
        return  new page<>((int)page.getTotal(), records, pageCurrent, pageSize);
    }
}

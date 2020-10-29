package com.cy.db.controller;

import com.cy.db.pojo.role;
import com.cy.db.service.roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class roleController {
    @Autowired
    private roleService rol;
//    用户角色（权限）加载
    @RequestMapping("doFindUserRole")
    public JsonResult doFinduserRole(){
        return new JsonResult(rol.findUserRole());
    }
//    修改角色信息
    @RequestMapping("doUpdateRole")
    public  JsonResult doUpdate(role entity, Integer[] menuIds){
       rol.updateObject(entity, menuIds);
       return  new JsonResult("update OK");
    }
//    根据角色id修改对应的权限菜单，先执行查询
    @RequestMapping("doFindByRoleId")
public JsonResult doFindByRoleId(Integer id){
    return  new JsonResult(rol.findById(id));
    }
//    角色保存和权限分配menu
    @RequestMapping("doSaveRole")
public JsonResult doSaveRole(role entity, Integer[] menuIds){
            rol.saveObject(entity, menuIds);
            return  new JsonResult("save ok");
    }
//    角色分页查询
    @GetMapping("DOFindRolePage")
    public  JsonResult doFindPageObject(String name,Integer pageCurrent){
    return  new JsonResult(rol.findPageObject(name,pageCurrent));
    }
}

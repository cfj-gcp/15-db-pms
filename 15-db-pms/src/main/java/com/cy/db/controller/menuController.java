package com.cy.db.controller;


import com.cy.db.pojo.menu;
import com.cy.db.service.menuServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class menuController {
    @Autowired
    private menuServic  menuServic;
//    更改菜单
    @RequestMapping("updateMenu")
    public JsonResult doUpdateObject(menu entity){
        menuServic.updateObject(entity);
        return new JsonResult("update  ok");
    }
//    插入菜单
    @PostMapping("saveMenu")
    public JsonResult  doSaveObject(menu entity){
        menuServic.insertObject(entity);
        return new JsonResult("save ok");
    }
    //    显示上级菜单
    @GetMapping("node")
    public  JsonResult doFindZtreeMenuNode(){
        return new JsonResult(menuServic.findZtreeMenuNodes());
    }
    @RequestMapping("deleteObject")
    public  JsonResult doDeleteObject(Integer id){
        menuServic.deleteObject(id);
        return  new JsonResult("delete ok");
    }
    @GetMapping("menu")
    public  JsonResult doFindObject(){
        return new JsonResult(menuServic.findObject());
    }
}

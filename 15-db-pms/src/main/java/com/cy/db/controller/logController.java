package com.cy.db.controller;

import com.cy.db.pojo.log;
import com.cy.db.pojo.page;
import com.cy.db.service.logService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class logController {
    @Autowired
  private   logService   logService;
@RequestMapping("deleteObject/{ids}")
public JsonResult doDeleteObjects(@PathVariable Integer... ids){
    logService.deleteObjects(ids);
    return new JsonResult("delete ok");
}
    @RequestMapping("findPageObject")
    public  JsonResult doFindPageObject(String username,Integer pageCurrent){
        page<log> pageObjects = logService.findPageObjects(username, pageCurrent);
        return new JsonResult(pageObjects);

    }
}

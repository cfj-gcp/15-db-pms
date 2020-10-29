package com.cy.db.service;

import com.cy.db.pojo.log;
import com.cy.db.pojo.page;
import org.apache.shiro.authz.annotation.RequiresPermissions;

public interface logService {
    void  SaveObject(log entity);

    @RequiresPermissions("sys:log:delete")
    int  deleteObjects(Integer... ids);
    page<log> findPageObjects(String username, Integer pageCurrent);
}

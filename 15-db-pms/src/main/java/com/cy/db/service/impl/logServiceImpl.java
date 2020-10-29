package com.cy.db.service.impl;

import com.cy.db.Dao.logDao;
import com.cy.db.common.annotation.RequiredLog;
import com.cy.db.common.exception.serviceException;
import com.cy.db.pojo.page;
import com.cy.db.pojo.log;
import com.cy.db.service.logService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Slf4j
public final class logServiceImpl implements logService {
    @Autowired
    private logDao  logDao;

    @Transactional(propagation = Propagation.REQUIRED)
    //写日志
    @Override
    public void SaveObject(com.cy.db.pojo.log entity) {
        String tname=Thread.currentThread().getName();
        System.out.println("logServiceImpl.SaveObject->thread.name->"+tname);
        try {
            Thread.sleep(5000);
        }catch (Exception e){};
        logDao.insertObject(entity);
    }

    @RequiredLog("日志删除")
    @Override
    public int deleteObjects(Integer... ids) {
//        参数校验
        if (ids==null||ids.length==0) throw  new IllegalArgumentException("必须提供正确的id值");
// 基于id删除日志
        int rows=logDao.deleteObjects(ids);
        if (rows==0)
            throw  new serviceException("记录可能已经不存在了");
        return rows;
    }
    @Transactional(readOnly = true)
    @RequiredLog("日志查询")
    @Override
    public page<log> findPageObjects(String username, Integer pageCurrent) {
        String tname=Thread.currentThread().getName();
        System.out.println("logServiceImpl.findPageObject->thread.name->"+tname);
        long t1=System.currentTimeMillis();
        //1.验证参数合法性
        //1.1验证pageCurrent的合法性，
        //不合法抛出IllegalArgumentException异常
        if(pageCurrent==null||pageCurrent<1)
            throw new IllegalArgumentException("当前页码不正确");
        //2.基于条件查询总记录数
        //2.1) 执行查询
        int rowCount=logDao.getRowCount(username);
        //2.2) 验证查询结果，假如结果为0不再执行如下操作
        if(rowCount==0) throw new serviceException("系统没有查到对应记录");
        //3.基于条件查询当前页记录(pageSize定义为2)
        //3.1)定义pageSize
        int pageSize=5;
        //3.2)计算startIndex
        int startIndex=(pageCurrent-1)*pageSize;
        //3.3)执行当前数据的查询操作
        List<log> records=
                logDao.findPageObjects(username, startIndex, pageSize);
        //4.对分页信息以及当前页记录进行封装
        //4.1)构建PageObject对象
        page<log> pageObject=new page<>();
        //4.2)封装数据
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setPageSize(pageSize);
        pageObject.setRowCount(rowCount);
        pageObject.setRecords(records);
        pageObject.setPageCount((rowCount-1)/pageSize+1);
        //5.返回封装结果。
        long t2 = System.currentTimeMillis();
        log.info("time()",t2-t1);
        return pageObject;
    }
}

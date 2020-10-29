package com.cy.db.service.impl;
import com.cy.db.Dao.userDao;
import com.cy.db.Dao.userRoleDao;
import com.cy.db.common.until.ValidUitls;
import com.cy.db.common.annotation.RequiredLog;
import com.cy.db.common.exception.serviceException;
import com.cy.db.pojo.page;
import com.cy.db.pojo.user;
import com.cy.db.pojo.userDept;
import com.cy.db.service.userService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@Transactional(readOnly = false,
                rollbackFor =Throwable.class,
        timeout=60,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
@Service
public class userServiceImpl  implements userService {
    @Autowired
    private userDao userDao;
    @Autowired
    private   userRoleDao  userRoleDao;
//修改用户密码
    @Override
    public int updatePassword(String password, String newPassword, String cfgPassword) {
        //1.判定新密码与密码确认是否相同
        if(StringUtils.isEmpty(newPassword))
            throw new IllegalArgumentException("新密码不能为空");
        if(StringUtils.isEmpty(cfgPassword))
            throw new IllegalArgumentException("确认密码不能为空");
        if(!newPassword.equals(cfgPassword))
            throw new IllegalArgumentException("两次输入的密码不相等");
        //2.判定原密码是否正确
        if(StringUtils.isEmpty(password))
            throw new IllegalArgumentException("原密码不能为空");
        //获取登陆用户
        user user=(user) SecurityUtils.getSubject().getPrincipal();
        SimpleHash sh=new SimpleHash("MD5",
                password, user.getSalt(), 1);
        if(!user.getPassword().equals(sh.toHex()))
            throw new IllegalArgumentException("原密码不正确");
        //3.对新密码进行加密
        String salt=UUID.randomUUID().toString();
        sh=new SimpleHash("MD5",newPassword,salt, 1);
        //4.将新密码加密以后的结果更新到数据库
        int rows=userDao.updatePassword(sh.toHex(), salt,user.getId());
        if(rows==0)
            throw new serviceException("修改失败");
        return rows;
    }

    //修改用户信息
    @Override
    public int updateObject(user entity, Integer[] roleIds) {
//        参数验证
        ValidUitls.isArgsValid(entity==null,"保存对象不能为空");
        ValidUitls.isArgsValid(StringUtils.isEmpty(entity.getUsername()),"用户名不能为空");
        ValidUitls.isArgsValid(roleIds==null||roleIds.length==0,"必须为其指定角色");
//更新用户与角色关系数据
        int i = userDao.updateObject(entity);
//        3.保存用户与角色的关系数据
        userRoleDao.deleteObjects(entity.getId());
        userRoleDao.insertObjects(entity.getId(), roleIds);
        return i;
    }
//根据角色id查询信息
    @Override
    public Map<String, Object> findObjectById(Integer userId) {
//        合法验证
        ValidUitls.isArgsValid(userId==null||userId<=0, "参数数据不合法");
//        查询
        userDept user = userDao.findObjectById(userId);
        ValidUitls.isArgsValid(user==null, "此用户不存在");
        List<Integer> role= userRoleDao.findRoleByUserId(userId);
//        数据封装
        HashMap<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("roleIds", role);
        return  map;
    }

    @RequiredLog("用户添加")
    @Override
    public int saveObjectUser(user entity, Integer[] roleIds) {
//参数校验
        ValidUitls.isArgsValid(entity==null, "保存对象不能为空");
        ValidUitls.isArgsValid(StringUtils.isEmpty(entity.getUsername()), "用户名不能为空");
        ValidUitls.isArgsValid(StringUtils.isEmpty(entity.getPassword()), "密码不能为空");
        ValidUitls.isArgsValid((roleIds==null||roleIds.length==0), "至少要为用户分配角色");
//  对密码进行加密
        String password = entity.getPassword();
//    产生随机字符，让此字符作为一个加密盐
        String salt= UUID.randomUUID().toString();
        SimpleHash sh = new SimpleHash("MD5", password, salt, 1);
        String newPassword = sh.toHex();
        entity.setSalt(salt);
        entity.setPassword(newPassword);
        //    保存用户自身信息
        int i = userDao.insertObject(entity);
//    保存用户和角色之间的关系数据
        userRoleDao.insertObjects(entity.getId(), roleIds);
        return  i;
    }
//方法上事务特性优先级要高于类上定义的事务特性
    //user状态的修改
@RequiresPermissions("sys:user:update")
    @Transactional(readOnly =false, rollbackFor = Throwable.class)//建议所有查询操作，事务的readonly属性值改为true
    @Override
    public int validById(Integer id, Integer valid) {
//        合法验证
        ValidUitls.isArgsValid(id==null, "参数不合法的id:"+id);
        ValidUitls.isArgsValid(valid==null||(valid!=1&&valid!=0), "参数不合格");
//        执行禁用或启用操作（admin为登录用户）
        int rows = userDao.validById(id, valid, "admin");
//        判定结果，并返回
        ValidUitls.isResultValid(rows==0,"此记录可能不存在");
        return rows;
    }

    @Override
    public page<userDept> findPageObject(String username, Integer pageCurrent) {
//    参数校验
        ValidUitls.isArgsValid(pageCurrent==null, "当前页码值无效");
        int rowCount = userDao.getRowCount(username);
        ValidUitls.isResultValid(rowCount==0, "没有找到对应的记录");
        int pageSize=6;
        int pageCount=(pageCurrent-1)*pageSize;
        List<userDept> records = userDao.findPageObjects(username, pageCount, pageSize);
//        对查询结果进行封装并返回
        return new page<>(pageCurrent, pageSize, rowCount, pageCount, records);

    }
}

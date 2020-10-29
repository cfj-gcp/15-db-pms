package com.cy.db.common.config.realm;

import com.cy.db.Dao.MenuDao;
import com.cy.db.Dao.RoleMenuDao;
import com.cy.db.Dao.userDao;
import com.cy.db.Dao.userRoleDao;
import com.cy.db.pojo.user;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;

@Service
public class shiroUserRealm  extends AuthorizingRealm {
@Autowired
private  userDao   userDao;
@Autowired
private userRoleDao  userRoleDao;
@Autowired
private RoleMenuDao  roleMenuDao;
@Autowired
private MenuDao   menuDao;
//此方法返回凭证加密对象，基于对象对用户输入的密码进行加密操作
    @Override
    public void setCredentialsMatcher(
            CredentialsMatcher credentialsMatcher) {
        //构建凭证匹配对象
        HashedCredentialsMatcher cMatcher=
                new HashedCredentialsMatcher();
        //设置加密算法
        cMatcher.setHashAlgorithmName("MD5");
        //设置加密次数
        cMatcher.setHashIterations(1);
        super.setCredentialsMatcher(cMatcher);
    }
//获取并封装认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1.获取用户名(用户页面输入)
        UsernamePasswordToken upToken= (UsernamePasswordToken)token;
        String username=upToken.getUsername();
        //2.基于用户名查询用户信息
        user user= userDao.findUserByUserName(username);
        //3.判定用户是否存在
        if(user==null)
            throw new UnknownAccountException();
        //4.判定用户是否已被禁用。
        if(user.getValid()==0)
            throw new LockedAccountException();

        //5.封装用户信息
        ByteSource credentialsSalt=
                ByteSource.Util.bytes(user.getSalt());
        //记住：构建什么对象要看方法的返回值
        SimpleAuthenticationInfo info=
                new SimpleAuthenticationInfo(
                        user,//principal (身份)
                        user.getPassword(),//hashedCredentials
                        credentialsSalt, //credentialsSalt
                        getName());//realName
        //6.返回封装结果
        return info;//返回值会传递给认证管理器(后续
        //认证管理器会通过此信息完成认证操作)
    }
    //    获取并封装授权信息（做授权业务时写此方法）
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection p) {
//        获取登录用户信息，例如用户id
        user user = (user)p.getPrimaryPrincipal();
        Integer userid = user.getId();
//        基于用户id获取用户角色
        List<Integer> roleIds = userRoleDao.findRoleByUserId(userid);
        if(roleIds==null||roleIds.size()==0) throw  new AuthorizationException();
//        3.基于角色id获取菜单信息
        List<Integer> menuIds = roleMenuDao.findMenuIdsByRoleIds(roleIds);
        if(menuIds==null||menuIds.size()==0)throw  new AuthorizationException();
//        4.基于菜单id获取权限标识
        List<String> permissions = menuDao.findpermissions(menuIds);
//        5.对权限标识信息进行封装并返回
        HashSet<String> set = new HashSet<>();
        for (String per : permissions) {
            if (!StringUtils.isEmpty(per)) {
                set.add(per);
                System.out.println("permission:" + per);
            }
        }
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(set);
            return  info;//返回给授权管理器
    }
}

package com.graduation.user.shiro;

import com.graduation.user.tables.pojos.GraStudentEntity;
import com.graduation.user.service.GraStudentService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhangxue
 * @date 2021.2.28 18:42 pm
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private GraStudentService graStudentService;

    /**
     * 授权逻辑
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 认证逻辑
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("开启认证逻辑");
        UsernamePasswordToken newToken = (UsernamePasswordToken) token;
        GraStudentEntity student = graStudentService.getStudentByStuId((newToken.getUsername()));
        if (student == null) {
            return null;
        }
        return new SimpleAuthenticationInfo("", student.getStuPasswd(), "");
    }
}

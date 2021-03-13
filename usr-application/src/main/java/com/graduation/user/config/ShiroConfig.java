package com.graduation.user.config;

import com.graduation.user.shiro.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxue
 * @date 2021.2.28 18:40 pm
 */
@Configuration
public class ShiroConfig {
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean filterFactory = new ShiroFilterFactoryBean();
        filterFactory.setSecurityManager(securityManager);
        filterFactory.setLoginUrl("/shiro/index");
        filterFactory.setSuccessUrl("/shiro/myIndex");
        System.out.println("过滤器被调用");
        Map<String, String> map = new HashMap<>();
        map.put("/**", "authc");
        map.put("/shiro/login", "anon");
        filterFactory.setFilterChainDefinitionMap(map);
        filterFactory.setUnauthorizedUrl("/shiro/noAnth");
        return filterFactory;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(UserRealm userRealm){
        return new DefaultWebSecurityManager(userRealm);
    }
}

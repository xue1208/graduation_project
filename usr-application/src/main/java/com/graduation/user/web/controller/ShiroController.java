package com.graduation.user.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhangxue
 */
@Controller
@RequestMapping("/shiro/")
public class ShiroController {
    @GetMapping("index")
    public String index() {
        System.out.println("index 被调用");
        return "login";
    }

    @GetMapping("add")
    public String add() {
        return "user/add";
    }

    @GetMapping("update")
    public String update() {
        return "user/update";
    }

    @GetMapping("login")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password, Model model) {
        System.out.println("入参为 name = " + name + " password = " + password);
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(name, password);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            model.addAttribute("msg", "用户名不存在");
            return "login";

        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            model.addAttribute("msg", "密码错误");
            return "login";
        }

        return "/index";
    }

    @GetMapping("/noAuth")
    public String noAuth() {
        return "user/noAuth";
    }

    @GetMapping("/myIndex")
    public String myIndex(){
        return "/index";
    }
}

package com.graduation.user.web.controller;

import com.graduation.user.result.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangxue
 */
@RestController
@RequestMapping("/shiro/")
public class ShiroController {
    @GetMapping("login")
    @CrossOrigin(origins = "*",maxAge = 3600)
    public Result<String> login(@RequestParam("name") String name, @RequestParam("password") String password, Model model) {
        System.out.println("入参为 name = " + name + " password = " + password);
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(name, password);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            model.addAttribute("msg", "用户名不存在");
            return Result.fail("用户名不存在");

        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            model.addAttribute("msg", "密码错误");
            return Result.fail("密码错误");
        }
        return Result.success();
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

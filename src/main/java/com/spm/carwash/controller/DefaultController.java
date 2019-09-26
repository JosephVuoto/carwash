package com.spm.carwash.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * @author Yangzhe Xie
 * @date 20/9/19
 */
@Controller
public class DefaultController {

    @GetMapping("/test")
    public String test() {
        return "/test";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/user")
    public String userInfo() {
        return "/user";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "/signup";
    }

    @RequestMapping("/profile")
    @ResponseBody
    public Principal profile(Principal principal) {
        return principal;
    }
}

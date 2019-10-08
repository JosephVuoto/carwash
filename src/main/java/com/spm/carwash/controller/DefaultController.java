package com.spm.carwash.controller;

import com.spm.carwash.pojo.User;
import com.spm.carwash.service.UserDetailsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * @author Yangzhe Xie
 * @date 20/9/19
 */
@Controller
public class DefaultController {
    @Resource
    UserDetailsServiceImpl userDetailsService;

    @GetMapping("/test")
    public String test() {
        return "/test";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "/signup";
    }

    @GetMapping("/submit")
    public String submit() {
        return "/submit";
    }

    @GetMapping("/info")
    public String info(Model model) {
        User user = userDetailsService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("car", user.getCars().get(0));
        return "/user";
    }
}

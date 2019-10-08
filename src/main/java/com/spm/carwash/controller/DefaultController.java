package com.spm.carwash.controller;

import com.google.gson.Gson;
import com.spm.carwash.pojo.TimeResponse;
import com.spm.carwash.pojo.User;
import com.spm.carwash.service.AppointmentService;
import com.spm.carwash.service.UserDetailsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.annotation.Resource;
import java.security.Principal;

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
        return"/submit";
    }

    @GetMapping("/info")
    public String info(Model model) {
        User user = userDetailsService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("car", user.getCars().get(0));
        return "/user";
    }
}

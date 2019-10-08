package com.spm.carwash.controller;

import com.spm.carwash.pojo.TimeResponse;
import com.spm.carwash.service.AppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * @author Yangzhe Xie
 * @date 20/9/19
 */
@Controller
public class DefaultController {

    @Resource
    AppointmentService appointmentService;

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

    @GetMapping("/submit")
    public String submit() {
        return"/submit";
    }

    @PostMapping("/doSignnup")
    @ResponseBody
    public String doSignup() {
        return "Hello world";
    }

    @RequestMapping("/profile")
    @ResponseBody
    public Principal profile(Principal principal) {
        return principal;
    }

    @RequestMapping("/time/get")
    @ResponseBody
    public TimeResponse getTime(String date) {
        return appointmentService.getTime(date);
    }
}

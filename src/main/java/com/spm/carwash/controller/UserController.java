package com.spm.carwash.controller;

import com.google.gson.Gson;
import com.spm.carwash.pojo.RegisterForm;
import com.spm.carwash.pojo.User;
import com.spm.carwash.pojo.UserCar;
import com.spm.carwash.service.UserDetailsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * @author Yangzhe Xie
 * @date 20/9/19
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    UserDetailsServiceImpl userDetailsService;

    @PostMapping("/doSginup")
    public String doSignup(RegisterForm registerForm) {
        User user = registerForm.getUser();
        userDetailsService.doRegister(user);

        UserCar userCar = registerForm.getUserCar();
        userCar.setUid(user.getUid());
        userDetailsService.addUserCar(userCar);
        return "redirect:/login";
    }
}

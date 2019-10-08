package com.spm.carwash.controller;

import com.google.gson.Gson;
import com.spm.carwash.common.StringUtil;
import com.spm.carwash.pojo.*;
import com.spm.carwash.service.AppointmentService;
import com.spm.carwash.service.UserDetailsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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
    @Resource
    AppointmentService appointmentService;

    @PostMapping("/doSignup")
    public RedirectView doSignup(RegisterForm registerForm, RedirectAttributes redirectAttributes) {
        if (userDetailsService.selectUser(registerForm.getEmail()) != null) {
            RedirectView redirectView = new RedirectView();
            redirectView.setContextRelative(true);
            redirectView.setUrl("/signup");
            redirectAttributes.addFlashAttribute("alertStatus", true);
            redirectAttributes.addFlashAttribute("alert", "The email address has already been registered");
            return redirectView;
        }
        if (!StringUtil.equals(registerForm.getPassword(),
                registerForm.getPasswordConfirm())) {
            RedirectView redirectView = new RedirectView();
            redirectView.setContextRelative(true);
            redirectView.setUrl("/signup");
            redirectAttributes.addFlashAttribute("alertStatus", true);
            redirectAttributes.addFlashAttribute("alert", "The password you enter twice must be the same.");
            return redirectView;
        }

        try {
            User user = registerForm.getUser();
            userDetailsService.doRegister(user);

            UserCar userCar = registerForm.getUserCar();
            userCar.setUid(user.getUid());
            userDetailsService.addUserCar(userCar);
            RedirectView redirectView = new RedirectView();
            redirectView.setUrl("/login");
            return redirectView;
        } catch (Exception e) {
            RedirectView redirectView = new RedirectView();
            redirectView.setContextRelative(true);
            redirectView.setUrl("/signup");
            redirectAttributes.addFlashAttribute("alertStatus", true);
            redirectAttributes.addFlashAttribute("alert", "Unknown error. Please try again.");
            return redirectView;
        }
    }
}

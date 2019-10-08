package com.spm.carwash.controller;

import com.spm.carwash.pojo.*;
import com.spm.carwash.service.AppointmentService;
import com.spm.carwash.service.UserDetailsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * @author Yangzhe Xie
 * @date 8/10/19
 */
@Controller
public class LogicController {
    @Resource
    UserDetailsServiceImpl userDetailsService;
    @Resource
    AppointmentService appointmentService;

    @PostMapping("doSubmit")
    public RedirectView doSubmit(AppointmentForm appointmentForm, RedirectAttributes redirectAttributes) {
        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/submit");
        if (appointmentForm.getCarType().equalsIgnoreCase("Choose a car type*")) {
            redirectAttributes.addFlashAttribute("alertStatus", true);
            redirectAttributes.addFlashAttribute("alert", "Please choose a car type");
        } else if (appointmentForm.getCarOption().equalsIgnoreCase("Choose a car wash option*")) {
            redirectAttributes.addFlashAttribute("alertStatus", true);
            redirectAttributes.addFlashAttribute("alert", "Please choose a car wash option");
        } else if (appointmentForm.getTime().equalsIgnoreCase("Choose a time slot*")) {
            redirectAttributes.addFlashAttribute("alertStatus", true);
            redirectAttributes.addFlashAttribute("alert", "Please choose a time slot");
        } else {
            try {
                NewAppointment appointment = appointmentForm.getAppointment();
                appointmentService.addAppointment(appointment);
                //TODO redirect to home page
            } catch (Exception e) {
                e.printStackTrace();
                redirectAttributes.addFlashAttribute("alertStatus", true);
                redirectAttributes.addFlashAttribute("alert", "Unknown error. Please try again.");
            }
        }
        return redirectView;
    }
    @PostMapping("/updateInfo")
    public RedirectView updateInfo(RegisterForm registerForm, RedirectAttributes redirectAttributes) {
        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/info");
        try {
            userDetailsService.updateUserInfo(registerForm);
            //TODO redirect to home page
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("alertStatus", true);
            redirectAttributes.addFlashAttribute("alert", "Unknown error. Please try again.");
        }
        return redirectView;
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

package com.spm.carwash.controller;

import com.google.gson.Gson;
import com.spm.carwash.pojo.AppointmentDetail;
import com.spm.carwash.pojo.NewAppointment;
import com.spm.carwash.pojo.User;
import com.spm.carwash.service.AppointmentService;
import com.spm.carwash.service.UserDetailsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

/**
 * @author Yangzhe Xie
 * @date 20/9/19
 */
@Controller
public class DefaultController {
    @Resource
    UserDetailsServiceImpl userDetailsService;
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

    @GetMapping("/update/{aid}")
    public String update(Model model, @PathVariable("aid") int aid) {
        if (appointmentService.getAppointDetail(aid).getUser().getUid()
                != userDetailsService.getCurrentUser().getUid()) {
            return "/";
        }
        AppointmentDetail appointment = appointmentService.getAppointDetail(aid);
        System.out.println(new Gson().toJson(appointment));
        model.addAttribute("app", appointment);
        return "/update";
    }
}

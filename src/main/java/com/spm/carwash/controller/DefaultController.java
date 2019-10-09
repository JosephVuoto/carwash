package com.spm.carwash.controller;

import com.google.gson.Gson;
import com.spm.carwash.pojo.AppointmentDetail;
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

    @GetMapping("/")
    public String test(Model model) {
        User user = userDetailsService.getCurrentUser();
        if (user.getRole() == 0) {
            model.addAttribute("title", "Your appointments");
            model.addAttribute("user", true);
        } else {
            model.addAttribute("title", "All appointments");
            model.addAttribute("user", false);
        }
        return "/list";
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

    @GetMapping("/detail/{aid}")
    public String update(Model model, @PathVariable("aid") int aid) {
        try {
            if (appointmentService.getAppointDetail(aid).getUser().getUid()
                    != userDetailsService.getCurrentUser().getUid()) {
                return "/";
            }
            AppointmentDetail appointment = appointmentService.getAppointDetail(aid);
            model.addAttribute("app", appointment);
            return "/detail";
        } catch (Exception e) {
            return "/";
        }
    }
}

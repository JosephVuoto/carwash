package com.spm.carwash.controller;

import com.google.gson.Gson;
import com.spm.carwash.exception.PermissionDeniedException;
import com.spm.carwash.exception.UnknownException;
import com.spm.carwash.pojo.AppointmentDetail;
import com.spm.carwash.pojo.SimpleAppointment;
import com.spm.carwash.pojo.User;
import com.spm.carwash.service.AppointmentService;
import com.spm.carwash.service.UserDetailsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

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
    public String index(Model model) throws UnknownException {
        try {
            User user = userDetailsService.getCurrentUser();
            model.addAttribute("name", user.getFirstname() + " " + user.getLastname());
            if (user.getRole() == 0) {
                model.addAttribute("title", "Your appointments");
                model.addAttribute("user", true);
                List<SimpleAppointment> apps = appointmentService.getUserAppointments(user.getUid());
                for (SimpleAppointment app: apps) {
                    app.setLinks(0);
                }
                model.addAttribute("apps", apps);
            } else {
                model.addAttribute("title", "All appointments");
                model.addAttribute("user", false);
                List<SimpleAppointment> apps = appointmentService.getAllAppointments();
                for (SimpleAppointment app: apps) {
                    app.setLinks(1);
                }
                model.addAttribute("apps", apps);
            }
            return "/list";
        } catch (Exception e) {
            throw new UnknownException();
        }
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
    public String update(Model model, @PathVariable("aid") int aid) throws UnknownException {
        try {
            User user = userDetailsService.getCurrentUser();
            AppointmentDetail appointment = appointmentService.getAppointDetail(aid);
            if (user.getRole() == 1) {
                model.addAttribute("app", appointment);
                model.addAttribute("user", appointment.getUser());
                return "/appointment";
            } else if (appointmentService.getAppointDetail(aid).getUser().getUid()
                    != user.getUid()) {
                throw new PermissionDeniedException();
            } else {
                model.addAttribute("app", appointment);
                return "/detail";
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new UnknownException();
        }
    }
}

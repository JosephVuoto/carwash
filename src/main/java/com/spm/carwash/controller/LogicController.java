package com.spm.carwash.controller;

import com.spm.carwash.pojo.AppointmentForm;
import com.spm.carwash.pojo.NewAppointment;
import com.spm.carwash.pojo.RegisterForm;
import com.spm.carwash.pojo.TimeResponse;
import com.spm.carwash.service.AppointmentService;
import com.spm.carwash.service.NotificationService;
import com.spm.carwash.service.UserDetailsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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
    @Resource
    NotificationService notificationService;

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
                notificationService.sendAppointmentEmail("Your appointment.", appointmentForm, userDetailsService.getCurrentUser());
                notificationService.sendAppointmentEmailToManagers("New appointment", appointmentForm, userDetailsService.getCurrentUser());
                redirectAttributes.addFlashAttribute("alertStatus", true);
                redirectAttributes.addFlashAttribute("alert", "Appointment submitted.");
                redirectView.setUrl("/");
            } catch (Exception e) {
                e.printStackTrace();
                redirectAttributes.addFlashAttribute("alertStatus", true);
                redirectAttributes.addFlashAttribute("alert", "Unknown error. Please try again.");
            }
        }
        return redirectView;
    }

    @PostMapping("/doUpdate")
    public RedirectView updateApp(AppointmentForm appointmentForm, RedirectAttributes redirectAttributes) {
        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/");

        try {
            if (appointmentForm.getDelete().equals("1")) {
                appointmentService.deleteAppointment(appointmentForm.getAid());
                notificationService.sendAppointmentEmail("Your appointment is canceled.", appointmentForm, userDetailsService.getCurrentUser());
                notificationService.sendAppointmentEmailToManagers("The appointment is canceled", appointmentForm, userDetailsService.getCurrentUser());
                redirectAttributes.addFlashAttribute("alertStatus", true);
                redirectAttributes.addFlashAttribute("alert", "Your information have been canceled.");
            } else {
                appointmentService.updateAppointment(appointmentForm.getAppointment());
                notificationService.sendAppointmentEmail("Your appointment is updated.", appointmentForm, userDetailsService.getCurrentUser());
                notificationService.sendAppointmentEmailToManagers("The appointment is updated.", appointmentForm, userDetailsService.getCurrentUser());
                redirectAttributes.addFlashAttribute("alertStatus", true);
                redirectAttributes.addFlashAttribute("alert", "Your information have been updated.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return redirectView;
    }

    @PostMapping("/updateInfo")
    public RedirectView updateInfo(RegisterForm registerForm, RedirectAttributes redirectAttributes) {
        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        try {
            userDetailsService.updateUserInfo(registerForm);
            redirectAttributes.addFlashAttribute("alertStatus", true);
            redirectAttributes.addFlashAttribute("alert", "Your information have been updated.");
            redirectView.setUrl("/");
        } catch (Exception e) {
            redirectView.setUrl("/info");
            redirectAttributes.addFlashAttribute("alertStatus", true);
            redirectAttributes.addFlashAttribute("alert", "Unknown error. Please try again.");
        }
        return redirectView;
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

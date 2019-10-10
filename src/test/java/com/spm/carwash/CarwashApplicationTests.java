package com.spm.carwash;

import com.google.gson.Gson;
import com.spm.carwash.common.DateUtil;
import com.spm.carwash.dao.AppointmentDao;
import com.spm.carwash.dao.UserDao;
import com.spm.carwash.pojo.NewAppointment;
import com.spm.carwash.pojo.SimpleAppointment;
import com.spm.carwash.pojo.User;
import com.spm.carwash.pojo.UserCar;
import com.spm.carwash.service.AppointmentService;
import com.spm.carwash.service.NotificationService;
import com.spm.carwash.service.UserDetailsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarwashApplicationTests {

    @Resource
    UserDao userDao;
    @Resource
    UserDetailsServiceImpl userDetailsService;
    @Resource
    AppointmentDao appointmentDao;
    @Resource
    AppointmentService appointmentService;
    @Resource
    NotificationService notificationService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
//        appointmentService.deleteAppointment(12);
        System.out.println(new Gson().toJson(appointmentService.getAllAppointments()));
//        appointmentService.deleteAppointment(9);
//        System.out.println(new Gson().toJson(appointmentService.getAppointDetail(10)));
//        notificationService.sendSimpleMail("joseph.vuoto@gmail.com", "hello", "world");
    }

}

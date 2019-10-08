package com.spm.carwash;

import com.google.gson.Gson;
import com.spm.carwash.common.DateUtil;
import com.spm.carwash.dao.AppointmentDao;
import com.spm.carwash.dao.UserDao;
import com.spm.carwash.pojo.NewAppointment;
import com.spm.carwash.pojo.User;
import com.spm.carwash.pojo.UserCar;
import com.spm.carwash.service.AppointmentService;
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

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
//        Date date = DateUtil.String2Date("07/10/2019");
//        System.out.println(date);
        System.out.println(new Gson().toJson(appointmentService.getTime("07/10/2019")));
    }

}

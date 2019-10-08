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
        String json = "{\"uid\":14,\"email\":null,\"password\":null,\"firstname\":\"Yang\",\"lastname\":\"Xie\",\"address\":\"570 Swanson St, Apartment 507\",\"phoneMobile\":\"0435233353\",\"phoneHome\":\"\",\"phoneWork\":\"\",\"role\":0,\"enabled\":null,\"cars\":[{\"cid\":0,\"carName\":\"123\",\"carNumber\":\"123\",\"carType\":\"Sedan\"}]}";
        User user = new Gson().fromJson(json, User.class);
        userDao.updateUserInfo(user);
    }

}

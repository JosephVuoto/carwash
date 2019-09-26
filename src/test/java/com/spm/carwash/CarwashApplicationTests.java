package com.spm.carwash;

import com.spm.carwash.dao.AppointmentDao;
import com.spm.carwash.dao.UserDao;
import com.spm.carwash.pojo.NewAppointment;
import com.spm.carwash.pojo.User;
import com.spm.carwash.pojo.UserCar;
import com.spm.carwash.service.UserDetailsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarwashApplicationTests {

    @Resource
    UserDao userDao;
    @Resource
    UserDetailsServiceImpl userDetailsService;
    @Resource
    AppointmentDao appointmentDao;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
        UserCar userCar = new UserCar();
        userCar.setUid(8);
        userCar.setCarName("test_name");
        userCar.setCarNumber("1234");
        userCar.setCarType(1);
        userDao.addUserCar(userCar);
    }

}

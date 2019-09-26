package com.spm.carwash;

import com.spm.carwash.dao.AppointmentDao;
import com.spm.carwash.dao.UserDao;
import com.spm.carwash.pojo.NewAppointment;
import com.spm.carwash.pojo.User;
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
        User user = new User();
        user.setName("Joseph");
        user.setPassword("12345678");
        user.setEmail("joseph@joseph.com");
        user.setRole(0);
        user.setEnabled(1);
        user.setAddress("123");
        userDetailsService.doRegister("joseph@joseph.com", "12345678",
                "joseph", "123", "1", "2", "3");
    }

}

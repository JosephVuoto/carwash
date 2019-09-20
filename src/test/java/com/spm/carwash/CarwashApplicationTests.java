package com.spm.carwash;

import com.spm.carwash.dao.UserDao;
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

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
        userDetailsService.doRegister("joseph.vuoto@gmail.com",
                "1234five", "joseph", "TEST", "1", "2", "3");
    }

}

package com.spm.carwash.service;

import com.google.gson.Gson;
import com.spm.carwash.dao.UserDao;
import com.spm.carwash.pojo.SecurityUser;
import com.spm.carwash.pojo.User;
import com.spm.carwash.pojo.UserCar;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Yangzhe Xie
 * @date 20/9/19
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    UserDao userDao;
    @Resource
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.selectByEmail(s);
        System.out.println(new Gson().toJson(user));
        return new SecurityUser(user);
    }

    public void doRegister(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.addUser(user);
    }

    public void addUserCar(UserCar userCar) {
        userDao.addUserCar(userCar);
    }
}

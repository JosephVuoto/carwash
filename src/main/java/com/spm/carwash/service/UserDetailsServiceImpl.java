package com.spm.carwash.service;

import com.google.gson.Gson;
import com.spm.carwash.dao.UserDao;
import com.spm.carwash.pojo.SecurityUser;
import com.spm.carwash.pojo.User;
import com.spm.carwash.pojo.UserCar;
import com.spm.carwash.pojo.UserSimple;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public UserSimple selectUser(String email) {
        return userDao.selectInfoByEmail(email);
    }

    public void doRegister(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.addUser(user);
    }

    public void addUserCar(UserCar userCar) {
        userDao.addUserCar(userCar);
    }

    /**
     * get the username of the current user of the request
     * @return username
     */
    public SecurityUser getCurrentUserName() {
        return (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    /**
     * get the information of the current user of the request
     * @return User object
     */
    public User getCurrentUser() {
        return getCurrentUserName().getUser();
    }
}

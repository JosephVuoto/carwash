package com.spm.carwash.service;

import com.spm.carwash.dao.UserDao;
import com.spm.carwash.pojo.SecurityUser;
import com.spm.carwash.pojo.User;
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
        return new SecurityUser(user);
    }

    public void doRegister(String email, String password,
                           String name, String address,
                           String phoneMobile, String phoneHome, String phoneWork) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setAddress(address);
        user.setPhoneMobile(phoneMobile);
        user.setPhoneHome(phoneHome);
        user.setPhoneWork(phoneWork);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        userDao.addUser(user);
    }
}

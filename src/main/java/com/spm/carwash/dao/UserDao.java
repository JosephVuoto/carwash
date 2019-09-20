package com.spm.carwash.dao;

import com.spm.carwash.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 20/9/19
 */
@Mapper
public interface UserDao {

    List<User> selectAllUsers();

    User selectByID(Integer id);

    User selectByEmail(String email);

    void addUser(User user);
}

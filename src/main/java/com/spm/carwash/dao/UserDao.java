package com.spm.carwash.dao;

import com.spm.carwash.pojo.User;
import com.spm.carwash.pojo.UserCar;
import com.spm.carwash.pojo.UserSimple;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 20/9/19
 */
@Mapper
public interface UserDao {

    List<UserSimple> selectAllUsers();

    User selectByID(Integer id);

    User selectByEmail(String email);

    UserSimple selectInfoByEmail(String email);

    void addUserCar(UserCar userCar);

    void addUser(User user);

    void updateUserInfo(User user);

    void updateUserCar(UserCar car);
}

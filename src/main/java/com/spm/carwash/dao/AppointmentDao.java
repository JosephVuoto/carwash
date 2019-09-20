package com.spm.carwash.dao;

import com.spm.carwash.pojo.Appointment;
import com.spm.carwash.pojo.NewAppointment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 20/9/19
 */
@Mapper
public interface AppointmentDao {
    void addAppointment(NewAppointment appointment);

    void addUserAppointment(@Param("uid") Integer uid,
                            @Param("aid") Integer aid);

    List<Appointment> selectAllAppointments();
}

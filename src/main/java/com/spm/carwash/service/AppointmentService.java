package com.spm.carwash.service;

import com.google.gson.Gson;
import com.spm.carwash.dao.AppointmentDao;
import com.spm.carwash.pojo.Appointment;
import com.spm.carwash.pojo.NewAppointment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Yangzhe Xie
 * @date 8/10/19
 */
@Service
public class AppointmentService {
    @Resource
    AppointmentDao appointmentDao;
    @Resource
    UserDetailsServiceImpl userDetailsService;

    public void addAppointment(NewAppointment appointment) {
        appointmentDao.addAppointment(appointment);
        Integer aid = appointment.getAid();
        appointmentDao.addUserAppointment(userDetailsService.getCurrentUser().getUid(), aid);
    }
}

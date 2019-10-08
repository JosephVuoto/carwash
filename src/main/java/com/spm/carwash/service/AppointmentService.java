package com.spm.carwash.service;

import com.google.gson.Gson;
import com.spm.carwash.common.DateUtil;
import com.spm.carwash.dao.AppointmentDao;
import com.spm.carwash.pojo.Appointment;
import com.spm.carwash.pojo.NewAppointment;
import com.spm.carwash.pojo.TimeResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public TimeResponse getTime(String dateStr) {
        if (DateUtil.times.isEmpty()) {
            DateUtil.times = appointmentDao.selectAllTime();
        }
        List<String> avail = new ArrayList<>();
        List<Integer> taken = appointmentDao.selectAllTakenTime(dateStr);
        for (int i = 0; i < DateUtil.times.size(); i++) {
            if (!taken.contains(i + 1)) {
                avail.add(DateUtil.times.get(i));
            }
        }

        TimeResponse timeResponse = new TimeResponse();
        timeResponse.setAvailableTime(avail);
        timeResponse.setDate(dateStr);
        return timeResponse;
    }
}

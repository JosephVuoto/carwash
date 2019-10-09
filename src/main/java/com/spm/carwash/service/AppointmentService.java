package com.spm.carwash.service;

import com.spm.carwash.common.DateUtil;
import com.spm.carwash.dao.AppointmentDao;
import com.spm.carwash.pojo.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
//        dateStr = dateStr.replace("-", "/");
//        String dateStr = "";
//        try {
//            long t = Long.parseLong(time);
//            Date date = new Date(t);
//            dateStr = DateUtil.Date2String(date);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
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

    public List<SimpleAppointment> getAllAppointments() {
        List<Appointment> aps = appointmentDao.selectAllAppointments();
        List<SimpleAppointment> result = new ArrayList<>();
        for (Appointment appointment : aps) {
            result.add(new SimpleAppointment(appointment));
        }
        return result;
    }

    public List<SimpleAppointment> getUserAppointments(Integer uid) {
        List<Appointment> aps = appointmentDao.selectAppointmentByUser(uid);
        List<SimpleAppointment> result = new ArrayList<>();
        for (Appointment appointment : aps) {
            result.add(new SimpleAppointment(appointment));
        }
        return result;
    }

    public void deleteAppointment(Integer aid) {
        appointmentDao.deleteAppointment(aid);
    }

    public AppointmentDetail getAppointDetail(Integer aid) {
        return new AppointmentDetail(appointmentDao.selectAppointmentById(aid));
    }

    public NewAppointment getAppointment(Integer aid) {
        return appointmentDao.selectAppointmentById(aid).getNewAppointment();
    }

    public void updateAppointment(NewAppointment appointment) {
        appointmentDao.updateAppointment(appointment);
    }
}

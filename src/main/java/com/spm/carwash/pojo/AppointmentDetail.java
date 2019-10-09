package com.spm.carwash.pojo;

import com.spm.carwash.common.DateUtil;

import java.util.Date;

/**
 * @author Yangzhe Xie
 * @date 8/10/19
 */
public class AppointmentDetail {
    private int aid;
    private String carType;
    private String date;
    private String time;
    private String option;
    private String comment;
    private UserSimple user;

    public AppointmentDetail(Appointment appointment) {
        String[] carTypes = {"Hatchback", "Sedan", "SUV"};
        String[] options = {"Wash outside only $15", "Wash inside and outside $25", "Deluxe wash $30"};
        this.aid = appointment.getAid();
        this.carType = carTypes[appointment.getCarType()];
        this.date = DateUtil.Date2String(appointment.getDate());
        this.time = appointment.getTime().getSlot();
        this.option = options[appointment.getOption()];
        this.comment = appointment.getComment();
        this.user = appointment.getUser();
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public UserSimple getUser() {
        return user;
    }

    public void setUser(UserSimple user) {
        this.user = user;
    }
}

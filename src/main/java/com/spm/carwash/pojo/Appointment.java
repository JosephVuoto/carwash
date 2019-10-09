package com.spm.carwash.pojo;

import java.util.Date;

/**
 * table name:  appointment
 * author name: joseph
 * create time: 2019/09/20 20:42:30
 */
public class Appointment {

    private int aid;
    private int carType;
    private Date date;
    private TimeSlot time;
    private int option;
    private String comment;
    private UserSimple user;

    public NewAppointment getNewAppointment() {
        NewAppointment appointment = new NewAppointment();
        appointment.setAid(aid);
        appointment.setCarType(carType);
        appointment.setOption(option);
        appointment.setComment(comment);
        appointment.setDate(date);
        appointment.setTime(time.getTsid());
        return appointment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getCarType() {
        return carType;
    }

    public void setCarType(int carType) {
        this.carType = carType;
    }

    public TimeSlot getTime() {
        return time;
    }

    public void setTime(TimeSlot time) {
        this.time = time;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
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


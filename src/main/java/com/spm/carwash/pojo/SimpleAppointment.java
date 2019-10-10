package com.spm.carwash.pojo;

import com.google.gson.Gson;
import com.spm.carwash.common.DateUtil;

import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 8/10/19
 */
public class SimpleAppointment {
    private int aid;
    private String carType;
    private String date;
    private String time;
    private String option;
    private String comment;
    private String link;

    public SimpleAppointment(Appointment appointment) {
        String[] carTypes = {"Hatchback", "Sedan", "SUV"};
        String[] options = {"Wash outside only $15", "Wash inside and outside $25", "Deluxe wash $30"};
        this.aid = appointment.getAid();
        this.carType = carTypes[appointment.getCarType() - 1];
        this.date = DateUtil.Date2String(appointment.getDate());
        this.time = appointment.getTime().getSlot();
        this.option = options[appointment.getOption() - 1];
        this.comment = appointment.getComment();
    }

    public void setLinks(int role) {
        if (role == 0) {
            link = "/detail/" + aid;
        } else {
            //TODO
            link = "#";
        }
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

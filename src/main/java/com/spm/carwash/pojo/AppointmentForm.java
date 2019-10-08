package com.spm.carwash.pojo;

import com.spm.carwash.common.DateUtil;

/**
 * @author Yangzhe Xie
 * @date 8/10/19
 */
public class AppointmentForm {
    private String carType;
    private String carOption;
    private String date;
    private String time;
    private String comment;

    public NewAppointment getAppointment() {
        NewAppointment appointment = new NewAppointment();
        switch (carType) {
            case "Hatchback":
                appointment.setCarType(1);
                break;
            case "Sedan":
                appointment.setCarType(2);
                break;
            case "SUV":
                appointment.setCarType(3);
                break;
        }
        switch (carOption) {
            case "Wash outside only $15":
                appointment.setOption(1);
                break;
            case "Wash inside and outside $25":
                appointment.setOption(2);
                break;
            case "Deluxe wash $30":
                appointment.setOption(3);
                break;
        }

        appointment.setDate(DateUtil.String2Date(date));
        appointment.setTime(new TimeSlot(time).getTsid());
        appointment.setComment(comment);

        return appointment;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarOption() {
        return carOption;
    }

    public void setCarOption(String carOption) {
        this.carOption = carOption;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

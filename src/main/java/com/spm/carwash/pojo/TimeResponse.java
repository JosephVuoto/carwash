package com.spm.carwash.pojo;

import java.util.List;

/**
 * @author Yangzhe Xie
 * @date 8/10/19
 */
public class TimeResponse {
    private String date;
    private List<String> availableTime;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<String> getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(List<String> availableTime) {
        this.availableTime = availableTime;
    }
}

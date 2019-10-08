package com.spm.carwash.pojo;

/**
 * table name:  time_slot
 * author name: joseph
 * create time: 2019/09/20 20:42:30
 */
public class TimeSlot {

    private int tsid;
    private String slot;

    public TimeSlot() {
    }

    public TimeSlot(String slot) {
        this.slot = slot;
        switch (slot) {
            case "09:00-09:40":
                this.tsid = 1;
                break;
            case "09:40-10:20":
                this.tsid = 2;
                break;
            case "10:20-11:00":
                this.tsid = 3;
                break;
            case "11:00-11:40":
                this.tsid = 4;
                break;
            case "11:40-12:20":
                this.tsid = 5;
                break;
            case "12:20-13:00":
                this.tsid = 6;
                break;
            case "13:00-13:40":
                this.tsid = 7;
                break;
            case "13:40-14:20":
                this.tsid = 8;
                break;
            case "14:20-15:00":
                this.tsid = 9;
                break;
            case "15:00-15:40":
                this.tsid = 10;
                break;
            case "15:40-16:20":
                this.tsid = 11;
                break;
            case "16:20-17:00":
                this.tsid = 12;
                break;
        }
    }

    public int getTsid() {
        return tsid;
    }

    public void setTsid(int tsid) {
        this.tsid = tsid;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }
}


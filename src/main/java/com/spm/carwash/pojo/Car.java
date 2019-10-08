package com.spm.carwash.pojo;

/**
 * table name:  car
 * author name: joseph
 * create time: 2019/09/20 18:54:05
 */
public class Car {

    private int cid;
    private String carName;
    private String carNumber;
    private String carType;

    public int getCid() {

        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}


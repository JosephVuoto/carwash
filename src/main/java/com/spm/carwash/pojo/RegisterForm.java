package com.spm.carwash.pojo;

import net.sf.jsqlparser.statement.select.First;

/**
 * @author Yangzhe Xie
 * @date 26/9/19
 */
public class RegisterForm {
    private String email;
    private String password;
    private String passwordConfirm;
    private String firstName;
    private String lastName;
    private String address;
    private String mobilePhone;
    private String homePhone;
    private String workPhone;
    private String carName;
    private String carPlateNumber;
    private String carType;

    public User getUser() {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(firstName + " " + lastName);
        user.setAddress(address);
        user.setPhoneMobile(mobilePhone);
        user.setPhoneHome(homePhone);
        user.setPhoneWork(workPhone);
        return user;
    }

    public UserCar getUserCar() {
        UserCar userCar = new UserCar();
        userCar.setCarNumber(carPlateNumber);
        userCar.setCarName(carName);
        int type = 1;
        switch (carType) {
            case "Hatchback":
                break;
            case "Sedan":
                type = 2;
                break;
            case "SUV":
                type = 3;
                break;
        }
        userCar.setCarType(type);
        return userCar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarPlateNumber() {
        return carPlateNumber;
    }

    public void setCarPlateNumber(String carPlateNumber) {
        this.carPlateNumber = carPlateNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}

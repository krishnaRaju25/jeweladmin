package com.thbs.jewellery.jewel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdminRegister {
    @Id
    private String email;
    private String password;
    private String mobileNumber;

    public AdminRegister(String email, String password, String mobileNumber) {
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
    }

    public AdminRegister() {
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "AdminRegister{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}

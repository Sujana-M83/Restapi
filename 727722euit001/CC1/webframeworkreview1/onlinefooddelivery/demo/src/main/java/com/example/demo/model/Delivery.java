package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="FoodDelivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Userid;
    String Emailid;
    String Username;
    String Password;
    String ConfirmPassword;
    public long getUserid() {
        return Userid;
    }
    public void setUserid(long userid) {
        Userid = userid;
    }
    public String getEmailid() {
        return Emailid;
    }
    public void setEmailid(String emailid) {
        Emailid = emailid;
    }
    public String getUsername() {
        return Username;
    }
    public void setUsername(String username) {
        Username = username;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public String getConfirmPassword() {
        return ConfirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }
}
package uk.co.theappexperts.modelviewpresenter.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User implements Serializable {

    private String mFirstName, mLastName, mEmail, mRegisteredDate, mUsername, mPassword;

    public String getFirstName() {
        return "Albert";
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return "Einstein";
    }

    public void setLastName(String lastName) {
        this.mLastName = lastName;
    }

    public String getEmail() {
        return "alber.einstein@science.world";
    }

    public void setEmail(String email) {
        this.mEmail = email;
    }

    public String getRegisteredDate() {
        return new SimpleDateFormat("yyyy/mm/dd HH:mm:ss").format(new Date());
    }

    public void setRegisteredDate(String registeredDate) {
        this.mRegisteredDate = registeredDate;
    }

    public String getUsername() {
        return "admin";
    }

    public void setUsername(String username) {
        this.mUsername = username;
    }

    public String getPassword() {
        return "admin";
    }

    public void setPassword(String password) {
        this.mPassword = password;
    }
}

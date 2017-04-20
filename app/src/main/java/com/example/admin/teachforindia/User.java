package com.example.admin.teachforindia;

import android.widget.EditText;

/**
 * Created by Admin on 4/16/2017.
 */

public class User {
    String name;
    String email;
    String phone;
    String locality;
    String message;

    public User(String name, String email, String phone, String locality, String message) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.locality = locality;
        this.message = message;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getMessage() {
        return message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

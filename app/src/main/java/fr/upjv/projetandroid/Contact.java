package fr.upjv.projetandroid;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String company;

    public Contact(String name, String phoneNumber, String email, String address, String company) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.company = company;
    }


    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return name + ", " + phoneNumber + ", " + email + ", " + address + ", " + company;
    }
}
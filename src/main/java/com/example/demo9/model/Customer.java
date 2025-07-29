package com.example.demo9.model;

import javax.persistence.*;

@Entity                                                 // mark this is an entity
@Table(name = "customer")                               // collate into database
public class Customer {
    @Id                                                     // PK
    @GeneratedValue(strategy = GenerationType.AUTO)         // auto increment
    private Integer cusID;
    private String cusName;
    private String cusAddress;
    private String cusPhone;
    private String cusEmail;
    private String cusImage;

    public Customer(Integer cusID, String cusName, String cusAddress, String cusPhone, String cusEmail, String cusImage) {
        this.cusID = cusID;
        this.cusName = cusName;
        this.cusAddress = cusAddress;
        this.cusPhone = cusPhone;
        this.cusEmail = cusEmail;
        this.cusImage = cusImage;
    }

    public Customer() {
    }

    public String getCusImage() {
        return cusImage;
    }

    public void setCusImage(String cusImage) {
        this.cusImage = cusImage;
    }

    public Integer getCusID() {
        return cusID;
    }

    public void setCusID(Integer cusID) {
        this.cusID = cusID;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }
}

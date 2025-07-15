package com.example.demo9.customer;

public class Customer {
    private int  cusID;
    private String  cusName;
    private String  cusAddress;
    private String  cusPhone;
    private String  cusEmail;

    public Customer(int cusID, String cusName, String cusAddress, String cusPhone, String cusEmail) {
        this.cusID = cusID;
        this.cusName = cusName;
        this.cusAddress = cusAddress;
        this.cusPhone = cusPhone;
        this.cusEmail = cusEmail;
    }

    public int getCusID() {
        return cusID;
    }

    public void setCusID(int cusID) {
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

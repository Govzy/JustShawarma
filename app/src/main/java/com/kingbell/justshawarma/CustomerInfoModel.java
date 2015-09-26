package com.kingbell.justshawarma;

/**
 * Created by Android on 9/8/2015.
 */
public class CustomerInfoModel {
    String customerName;
    String customerEmail;
    //String phoneNumber;
    String customerAddress1;
    String CustomerAddress2;
    String customerZip;

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerZip() {
        return customerZip;
    }

    public void setCustomerZip(String customerZip) {
        this.customerZip = customerZip;
    }

    String customerCity;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress1() {
        return customerAddress1;
    }

    public void setCustomerAddress1(String customerAddress1) {
        this.customerAddress1 = customerAddress1;
    }

    public String getCustomerAddress2() {
        return CustomerAddress2;
    }

    public void setCustomerAddress2(String customerAddress2) {
        CustomerAddress2 = customerAddress2;
    }
}

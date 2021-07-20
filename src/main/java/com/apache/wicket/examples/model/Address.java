package com.apache.wicket.examples.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Ajithlal
 * @created 16/07/2021-6:38 PM
 * @project ApacheWicket-Chapter01
 */
public class Address implements java.io.Serializable{

    private String name;
    private String street;
    private String zipcode;
    private String city;
    private String category;
    private Date pickDate;

    public String getCategory() {
        return category;
    }

    public Date getPickDate() {
        return pickDate;
    }

    public void setPickDate(Date pickDate) {
        this.pickDate = pickDate;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

package com.apache.wicket.examples.model;

/**
 * @author Ajithlal
 * @created 17/07/2021-8:00 PM
 * @project ApacheWicket-Chapter01
 */
public class Customer implements java.io.Serializable{
    public Customer() {
    }
    private String name;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

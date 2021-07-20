package com.apache.wicket.examples.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ajithlal
 * @created 16/07/2021-6:40 PM
 * @project ApacheWicket-Chapter01
 */
public class Cart implements java.io.Serializable{

    private List<Cheese> cheeses=new ArrayList<>();
    private Address billingAddress=new Address();

    public List<Cheese> getCheeses() {
        return cheeses;
    }

    public void setCheeses(List<Cheese> cheeses) {
        this.cheeses = cheeses;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public double getTotal(){
        double total=0;
        for (Cheese cheese:cheeses){
            total+=cheese.getPrice();
        }
        return total;
    }
}

package com.apache.wicket.examples.model;

/**
 * @author Ajithlal
 * @created 16/07/2021-6:36 PM
 * @project ApacheWicket-Chapter01
 */
public class Cheese  implements java.io.Serializable{

    private String name;
    private String description;
    private double price;

    public Cheese(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

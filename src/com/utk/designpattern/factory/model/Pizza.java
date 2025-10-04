package com.utk.designpattern.factory.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pizza {

    private static final Logger LOGGER = Logger.getLogger(Pizza.class.getName());

    String name;
    String dough;
    String sauce;
    List<String> toppings = new ArrayList<>();

    public void prepare() {
        LOGGER.log(Level.INFO, "Preparing : {0}", name);
        LOGGER.log(Level.INFO, "Tossing dough.....");
        LOGGER.log(Level.INFO, "Adding sauce....");
        LOGGER.log(Level.INFO, "Adding toppings.....");
        for (Object topping : toppings) {
            LOGGER.log(Level.INFO, "Adding toppings....{0}", topping);
        }
    }

    public void bake(){
        LOGGER.log(Level.INFO, "Bake for 25 to 30 minutes");
    }

    public void cut(){
        LOGGER.log(Level.INFO, "Cut the pizza into small slices.....");
    }

    public void box(){
        LOGGER.log(Level.INFO, "Boxing the pizza in official Pizza store box.");
    }

    public String getName() {
        return name;
    }
}

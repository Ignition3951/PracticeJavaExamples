package com.utk.designpattern.factory.model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ChicagoStyleCheesePizza extends Pizza {

    private static final Logger LOGGER = Logger.getLogger(ChicagoStyleCheesePizza.class.getName());

    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese");
    }

    @Override
    public void cut() {
        LOGGER.log(Level.INFO, "Cut the pizza into chicago style squares.");
    }
}

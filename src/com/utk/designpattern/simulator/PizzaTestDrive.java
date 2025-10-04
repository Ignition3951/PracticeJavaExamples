package com.utk.designpattern.simulator;

import com.utk.designpattern.factory.ChicagoPizzaStore;
import com.utk.designpattern.factory.NyPizzaStore;
import com.utk.designpattern.factory.PizzaStore;
import com.utk.designpattern.factory.model.Pizza;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PizzaTestDrive {

    private static final Logger LOGGER = Logger.getLogger(PizzaTestDrive.class.getName());

    public static void main(String[] args) {
        PizzaStore nyPizzaStore = new NyPizzaStore();
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();

        Pizza nyPizza = nyPizzaStore.orderPizza("cheese");
        LOGGER.log(Level.INFO, "Ethan ordered a : {0}", nyPizza.getName());

        Pizza chicagoPizza = chicagoPizzaStore.orderPizza("cheese");
        LOGGER.log(Level.INFO, "Joel ordered a : {0}", chicagoPizza.getName());
    }
}

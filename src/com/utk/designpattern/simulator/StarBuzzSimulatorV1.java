package com.utk.designpattern.simulator;

import com.utk.designpattern.decorator.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StarBuzzSimulatorV1 {

    private static final Logger LOGGER = Logger.getLogger(StarBuzzSimulatorV1.class.getName());

    public static void main(String[] args) {
        Beverage beverage1 = new Espresso();
        LOGGER.log(Level.INFO, "{0} : ${1}", new Object[]{beverage1.getDescription(), beverage1.cost()});

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        LOGGER.log(Level.INFO, "{0} : ${1}", new Object[]{beverage2.getDescription(), beverage2.cost()});

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        LOGGER.log(Level.INFO, "{0} : ${1}", new Object[]{beverage3.getDescription(), beverage3.cost()});
    }
}

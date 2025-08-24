package com.utk.designpattern.strategy;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RedheadDuck extends Duck {

    public static final Logger LOGGER = Logger.getLogger(RedheadDuck.class.getName());

    @Override
    public void display() {
        LOGGER.log(Level.INFO, "The display method of RedheadDuck!!!");
    }
}

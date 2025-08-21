package com.utk.designpattern.model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MallardDuck extends Duck {

    public static final Logger LOGGER = Logger.getLogger(MallardDuck.class.getName());

    @Override
    public void display() {
        LOGGER.log(Level.INFO, "The display method of MallardDuck!!!");
    }
}

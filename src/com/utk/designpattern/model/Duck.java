package com.utk.designpattern.model;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Duck {

    public static final Logger LOGGER = Logger.getLogger(Duck.class.getName());

    public void quack() {
        LOGGER.log(Level.INFO, "The super quack method!!!");
    }

    public void swim() {
        LOGGER.log(Level.INFO, "The super swim method!!!");
    }

    public abstract void display();
}

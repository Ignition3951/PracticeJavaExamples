package com.utk.designpattern.model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Quack implements QuackBehaviour {

    public static final Logger LOGGER = Logger.getLogger(Quack.class.getName());

    @Override
    public void quack() {
        LOGGER.log(Level.INFO, "The quack implementation method!!!");
    }
}

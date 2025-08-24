package com.utk.designpattern.strategy;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Squeak implements QuackBehaviour{

    public static final Logger LOGGER = Logger.getLogger(Squeak.class.getName());

    @Override
    public void quack() {
        LOGGER.log(Level.INFO, "The squeak implementation method!!!");
    }
}

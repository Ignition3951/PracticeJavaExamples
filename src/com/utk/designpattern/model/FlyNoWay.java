package com.utk.designpattern.model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FlyNoWay implements FlyBehaviour {

    public static final Logger LOGGER = Logger.getLogger(FlyNoWay.class.getName());

    @Override
    public void fly() {
        LOGGER.log(Level.INFO, "The no fly implementation method!!!");
    }
}

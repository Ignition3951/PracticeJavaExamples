package com.utk.designpattern.model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FlyWithWings implements FlyBehaviour {

    public static final Logger LOGGER = Logger.getLogger(FlyWithWings.class.getName());

    @Override
    public void fly() {
        LOGGER.log(Level.INFO, "The fly with wings implementation method!!!");
    }
}

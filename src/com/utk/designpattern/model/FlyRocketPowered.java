package com.utk.designpattern.model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FlyRocketPowered implements FlyBehaviour {

    public static final Logger LOGGER = Logger.getLogger(FlyRocketPowered.class.getName());

    @Override
    public void fly() {
        LOGGER.log(Level.INFO, "I m flying with the help of rockets!!!");
    }
}

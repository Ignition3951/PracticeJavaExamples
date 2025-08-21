package com.utk.designpattern.model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MuteQuack implements QuackBehaviour {

    public static final Logger LOGGER = Logger.getLogger(MuteQuack.class.getName());

    @Override
    public void quack() {
        LOGGER.log(Level.INFO, "The mute quack implementation method!!!");
    }
}

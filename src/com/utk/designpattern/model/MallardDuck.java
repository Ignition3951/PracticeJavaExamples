package com.utk.designpattern.model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MallardDuck extends Duck {

    public static final Logger LOGGER = Logger.getLogger(MallardDuck.class.getName());

    public MallardDuck() {
        flyBehaviour = new FlyWithWings();
        quackBehaviour = new Quack();
    }

    @Override
    public void display() {
        LOGGER.log(Level.INFO, "The display method of MallardDuck!!!");
    }
}

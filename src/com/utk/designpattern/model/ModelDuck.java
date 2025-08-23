package com.utk.designpattern.model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ModelDuck extends Duck {

    public static final Logger LOGGER = Logger.getLogger(ModelDuck.class.getName());

    public ModelDuck() {
        flyBehaviour = new FlyNoWay();
        quackBehaviour = new Quack();
    }

    @Override
    public void display() {
        LOGGER.log(Level.INFO, "I m a model duck!!!");
    }
}

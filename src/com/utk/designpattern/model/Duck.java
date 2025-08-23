package com.utk.designpattern.model;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Duck {

    FlyBehaviour flyBehaviour;

    QuackBehaviour quackBehaviour;

    public static final Logger LOGGER = Logger.getLogger(Duck.class.getName());

    public void swim() {
        LOGGER.log(Level.INFO, "All ducks can swim!!!");
    }

    public void performFly() {
        flyBehaviour.fly();
    }

    public void performQuack() {
        quackBehaviour.quack();
    }

    public void setFlyBehavior(FlyBehaviour flyBehavior) {
        this.flyBehaviour = flyBehavior;
    }

    public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }

    public abstract void display();
}

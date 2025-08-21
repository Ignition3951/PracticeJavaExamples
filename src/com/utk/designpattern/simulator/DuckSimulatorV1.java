package com.utk.designpattern.simulator;

import com.utk.designpattern.model.Duck;
import com.utk.designpattern.model.MallardDuck;

public class DuckSimulatorV1 {

    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.performFly();
        mallardDuck.performQuack();
    }
}

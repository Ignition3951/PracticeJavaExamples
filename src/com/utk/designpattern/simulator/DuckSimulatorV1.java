package com.utk.designpattern.simulator;

import com.utk.designpattern.strategy.Duck;
import com.utk.designpattern.strategy.FlyRocketPowered;
import com.utk.designpattern.strategy.MallardDuck;
import com.utk.designpattern.strategy.ModelDuck;

public class DuckSimulatorV1 {

    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.performFly();
        mallardDuck.performQuack();

        Duck modelDuck = new ModelDuck();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new FlyRocketPowered());
        modelDuck.performFly();
    }
}

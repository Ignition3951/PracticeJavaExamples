package com.utk.designpattern.simulator;

import com.utk.designpattern.model.Duck;
import com.utk.designpattern.model.FlyRocketPowered;
import com.utk.designpattern.model.MallardDuck;
import com.utk.designpattern.model.ModelDuck;

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

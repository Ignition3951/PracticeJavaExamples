package com.utk.designpattern.factory;

import com.utk.designpattern.factory.model.NYStyleCheesePizza;
import com.utk.designpattern.factory.model.Pizza;

public class NyPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) return new NYStyleCheesePizza();
        return null;
    }
}

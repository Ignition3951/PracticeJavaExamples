package com.utk.designpattern.factory;

import com.utk.designpattern.factory.model.ChicagoStyleCheesePizza;
import com.utk.designpattern.factory.model.Pizza;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) return new ChicagoStyleCheesePizza();
        return null;
    }
}

package com.utk.designpattern.observer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CurrentConditionDisplay implements Observer, DisplayElement {
    float temperature;
    float pressure;
    float humidity;
    Subject weatherData;

    private static final Logger LOGGER = Logger.getLogger(CurrentConditionDisplay.class.getName());

    public CurrentConditionDisplay(Subject weatherData){
        this.weatherData=weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void display() {
        LOGGER.log(Level.INFO, "This is the CurrentConditionDisplay : temperature : {0} " +
                "pressure: {1} humidity: {2}", new Object[]{temperature, pressure, humidity});
    }

    @Override
    public void update(float temp, float pressure, float humidity) {
        this.temperature=temp;
        this.pressure=pressure;
        this.humidity=humidity;
        display();
    }
}

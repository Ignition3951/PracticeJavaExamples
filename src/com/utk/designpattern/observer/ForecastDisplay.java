package com.utk.designpattern.observer;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ForecastDisplay implements Observer, DisplayElement {

    float temperature;
    float pressure;
    float humidity;
    Observable observable;

    private static final Logger LOGGER = Logger.getLogger(ForecastDisplay.class.getName());

    public ForecastDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        LOGGER.log(Level.INFO, "This is the ForecastDisplay : temperature : {0} " +
                "pressure: {1} humidity: {2}", new Object[]{temperature, pressure, humidity});
    }

    @Override
    public void update(Observable o, Object arg) {
        this.observable = o;
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
            this.temperature = weatherData.getTemperature();
            display();
        }
    }
}

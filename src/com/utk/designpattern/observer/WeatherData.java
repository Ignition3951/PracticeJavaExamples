package com.utk.designpattern.observer;

import java.util.Observable;

public class WeatherData extends Observable {

    float temperature;
    float pressure;
    float humidity;

    public WeatherData() {
    }

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temp, float pressure, float humidity) {
        this.temperature = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }
}

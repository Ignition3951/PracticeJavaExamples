package com.utk.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

    List<Observer> observers;
    float temperature;
    float pressure;
    float humidity;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if (index > 0) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, pressure, humidity);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temp, float pressure, float humidity) {
        this.temperature = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        measurementsChanged();
    }

}

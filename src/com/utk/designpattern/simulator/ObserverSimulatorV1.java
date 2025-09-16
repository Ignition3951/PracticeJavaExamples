package com.utk.designpattern.simulator;

import com.utk.designpattern.observer.CurrentConditionDisplay;
import com.utk.designpattern.observer.ForecastDisplay;
import com.utk.designpattern.observer.StatisticsDisplay;
import com.utk.designpattern.observer.WeatherData;

public class ObserverSimulatorV1 {

    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}

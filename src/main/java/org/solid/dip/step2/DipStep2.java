package org.solid.dip.step2;

import java.util.HashMap;
import java.util.Map;

interface Notifier {
    String generateWeatherAlert(String weatherConditions);
}

class Emailer implements Notifier {
    @Override
    public String generateWeatherAlert(String weatherConditions) {
        String alert = "It is " + weatherConditions;
        return alert;
    }
}

class Phone implements Notifier {
    @Override
    public String generateWeatherAlert(String weatherConditions) {
        String alert = "It is " + weatherConditions;
        return alert;
    }
}

class WeatherTracker {
    String currentConditions;
    Notifier notifier;

    public WeatherTracker(Notifier notifier) {
        this.notifier = notifier;
    }

    public void setCurrentConditions(String weatherDescription) {
        this.currentConditions = weatherDescription;
        String alert = notifier.generateWeatherAlert(weatherDescription);
        System.out.print(alert);
    }
}

class WeatherTrackerTest {
    public static void main(String[] args) {
        Map<String, Notifier> notifierMap = new HashMap<>();
        notifierMap.put("rainy", new Phone());
        notifierMap.put("sunny", new Emailer());

        WeatherTracker weatherTracker = new WeatherTracker(notifierMap.get("sunny"));
//        WeatherTracker weatherTracker = new WeatherTracker(notifierMap.get("rainy"));
    }
}
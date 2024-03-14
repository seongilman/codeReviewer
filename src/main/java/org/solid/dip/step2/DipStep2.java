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
    private final Map<String, Notifier> notifierMap;
    private Notifier notifier;

    public WeatherTracker(Map<String, Notifier> notifierMap) {
        this.notifierMap = notifierMap;
    }

    public void notify(String weatherDescription) {
        notifier = notifierMap.get(weatherDescription);
        String alert = notifier.generateWeatherAlert(weatherDescription);
        System.out.print(alert);
    }
}

class WeatherTrackerTest {
    public static void main(String[] args) {
        //Notifier 구현체 등록
        Map<String, Notifier> notifierMap = new HashMap<>();
        notifierMap.put("rainy", new Phone());
        notifierMap.put("sunny", new Emailer());

        //Notifier 구현체 주입
        WeatherTracker weatherTracker = new WeatherTracker(notifierMap);
        weatherTracker.notify("rainy");
        weatherTracker.notify("sunny");
    }
}
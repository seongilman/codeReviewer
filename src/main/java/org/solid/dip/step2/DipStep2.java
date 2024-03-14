package org.solid.dip.step2;

import java.util.HashMap;
import java.util.Map;

enum WeatherType {
    SUNNY("sunny"),
    RAINY("rainy")
    ;
    private String weather;
    WeatherType(String weather) {
        this.weather = weather;
    }
    public String getWeather() {
        return this.weather;
    }
}

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
    private final Map<WeatherType, Notifier> notifierMap;
    private Notifier notifier;

    public WeatherTracker(Map<WeatherType, Notifier> notifierMap) {
        this.notifierMap = notifierMap;
    }

    public void notify(WeatherType weatherType) {
        notifier = notifierMap.get(weatherType);
        String alert = notifier.generateWeatherAlert(weatherType.getWeather());
        System.out.print(alert);
    }
}

class WeatherTrackerTest {
    public static void main(String[] args) {
        //Notifier 구현체 등록
        Map<WeatherType, Notifier> notifierMap = new HashMap<>();
        notifierMap.put(WeatherType.RAINY, new Phone());
        notifierMap.put(WeatherType.SUNNY, new Emailer());

        //weatherDescription에 따라 구현체를 선택하도록 구현체가 아닌 구현제 목록 주입
        WeatherTracker weatherTracker = new WeatherTracker(notifierMap);
        weatherTracker.notify(WeatherType.RAINY);
        weatherTracker.notify(WeatherType.SUNNY);
    }
}
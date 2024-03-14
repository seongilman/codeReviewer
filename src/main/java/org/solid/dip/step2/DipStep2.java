package org.solid.dip.step2;

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
        notifier = notifier;
    }

    public void setCurrentConditions(String weatherDescription) {
        this.currentConditions = weatherDescription;
        String alert = notifier.generateWeatherAlert(weatherDescription);
        System.out.print(alert);
    }
}
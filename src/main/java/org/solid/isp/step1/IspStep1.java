package org.solid.isp.step1;

interface Bird {
    public void molt();
}

interface FlyableBird extends Bird {
    public void fly();
}

interface UnFlyableBird extends Bird {
    public void swim();
}

class Penguin implements UnFlyableBird {
    String currentLocation;
    int numberOfFeathers;

    public Penguin(int initialFeatherCount) {
        this.numberOfFeathers = initialFeatherCount;
    }

    public void molt() {
        this.numberOfFeathers -= 1;
    }

    public void swim() {
        this.currentLocation = "in the water";
    }
}

class Eagle implements FlyableBird {
    String currentLocation;
    int numberOfFeathers;

    public Eagle(int initialFeatherCount) {
        this.numberOfFeathers = initialFeatherCount;
    }

    public void fly() {
        this.currentLocation = "in the air";
    }

    public void molt() {
        this.numberOfFeathers -= 1;
    }
}
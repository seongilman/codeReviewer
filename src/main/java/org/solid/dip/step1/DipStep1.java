package org.solid.dip.step1;

interface Vehicle {
    void accelerate();
}

class Pilot {

    private Vehicle vehicle;

    public Pilot(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public void increaseSpeed(){
        vehicle.accelerate();
    }
}

class RacingCar implements Vehicle {

    private final int maxFuel;
    private int remainingFuel;
    private int power;

    public RacingCar(final int maxFuel) {
        this.maxFuel = maxFuel;
        remainingFuel = maxFuel;
    }

    @Override
    public void accelerate(){
        power++;
        remainingFuel--;
    }

}
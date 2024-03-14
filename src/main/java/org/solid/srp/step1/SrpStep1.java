package org.solid.srp.step1;

class FuelSystem {
    public void reFuel(Vehicle vehicle, int fuel) {
        int addFuel = vehicle.getMaxFuel() - vehicle.getRemainingFuel();
        vehicle.setRemainingFuel(addFuel);
    }
}

class Vehicle {

    private final int maxFuel;
    private int remainingFuel;

    public Vehicle(final int maxFuel) {
        this.maxFuel = maxFuel;
        remainingFuel = maxFuel;
    }

    public int getMaxFuel() {
        return maxFuel;
    }

    public int getRemainingFuel() {
        return remainingFuel;
    }

    public void setRemainingFuel(final int remainingFuel) {
        this.remainingFuel = remainingFuel;
    }

    public void accelerate() {
        remainingFuel--;
    }
}

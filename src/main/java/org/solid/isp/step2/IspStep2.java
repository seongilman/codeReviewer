package org.solid.isp.step2;

interface Switches {
    void startEngine();
    void shutDownEngine();
}

interface DroneSwitches extends Switches {
    void turnCameraOn();
    void turnCameraOff();
}

interface VehicleSwitches extends Switches {
    void turnRadioOn();
    void turnRadioOff();
}

abstract class Vehicle implements VehicleSwitches {
    private boolean engineRunning;

    public boolean isEngineRunning() {
        return engineRunning;
    }
    @Override
    public void startEngine() {
        engineRunning = true;
    }
    @Override
    public void shutDownEngine() {
        engineRunning = false;
    }
}

abstract class DroneMachine implements DroneSwitches {
    private boolean engineRunning;

    public boolean isEngineRunning() {
        return engineRunning;
    }
    @Override
    public void startEngine() {
        engineRunning = true;
    }
    @Override
    public void shutDownEngine() {
        engineRunning = false;
    }
}

class Car extends Vehicle {
    private boolean radioOn;

    public boolean isRadioOn() {
        return radioOn;
    }
    @Override
    public void turnRadioOn() {
        radioOn = true;
    }
    @Override
    public void turnRadioOff() {
        radioOn = false;
    }
}

class Drone extends DroneMachine {
    private boolean cameraOn;

    public boolean isCameraOn() {
        return cameraOn;
    }

    @Override
    public void turnCameraOn() {
        cameraOn = true;
    }
    @Override
    public void turnCameraOff() {
        cameraOn = false;
    }
}
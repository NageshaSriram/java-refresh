package org.example;

abstract class Vehicle {
    abstract void start();

    void stop() {
        System.out.println("Vehicle stopped");
    }
}

class CarT extends Vehicle {

    @Override
    void start() {
        System.out.println("CarT started...");
    }
}


public class AbstractTest {
    public static void main(String[] args) {
        CarT carT = new CarT();
        carT.start();
        carT.stop();

        Vehicle vehicle = new Vehicle() {
            @Override
            void start() {
                System.out.println("Inner class1");
            }
        };

        vehicle.start();
    }
}

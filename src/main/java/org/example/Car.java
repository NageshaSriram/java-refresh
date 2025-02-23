package org.example;

public class Car {
    String brand;
    int price;

    public static void display() {
        System.out.println("THis is a carr");
    }

    public void myMethod() {
        System.out.println("Car brand " + brand + " and it's price " + price);
    }

    public static void main(String[] args) {
        display();
    }
}

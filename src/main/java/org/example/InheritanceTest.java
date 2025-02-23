package org.example;

class Animal {
    void eat() {
        System.out.println("This animal eats food");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Bow Bow...");
    }
}

public class InheritanceTest {
    public static void main(String[] args) {
        System.out.println("Inheritance ");
        Dog dog = new Dog();
        dog.eat();
        dog.bark();
    }
}

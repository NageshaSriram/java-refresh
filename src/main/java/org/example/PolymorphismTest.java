package org.example;


class MathOperation {
    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a = b + c;
    }
}

class AnimalT {
    void makeSound() {
        System.out.println("AnimalT makes sound");
    }
}

class DogT extends AnimalT {

    void makeSound() {
        System.out.println("Dog makes sound");
    }
}

public class PolymorphismTest {
    public static void main(String[] args) {
        MathOperation mathOperation = new MathOperation();
        System.out.println(mathOperation.add(10, 20));
        System.out.println(mathOperation.add(10, 20, 30));

        DogT dogT = new DogT();
        dogT.makeSound();
    }
}

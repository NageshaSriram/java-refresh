package org.example.threads;

class PrintNumbers {
    int number = 1;
    public synchronized  void odd() {
        try {
            while (number < 10) {
                while (number % 2 == 0) {
                    wait();
                }
                System.out.println(Thread.currentThread().getName() + " -> " + number);
                number += 1;
                notify();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    public synchronized  void even() {
        try {
            while (number < 10) {
                while (number % 2 == 1) {
                    wait();
                }
                System.out.println(Thread.currentThread().getName() + " -> " + number);
                number += 1;
                notify();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}

public class LearningThreads {
    public static void main(String[] args) throws InterruptedException{
        try {
            PrintNumbers printNumbers = new PrintNumbers();
            Thread t1 = new Thread(printNumbers::odd);
            Thread t2 = new Thread(printNumbers::even);
            t2.start();
            t1.start();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

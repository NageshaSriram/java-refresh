package org.example;

public class Loops {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        int n = 0;
        while (n <= 10) {
            System.out.println(n);
            n++;
        }


        do {
            System.out.println(n);
            n--;
        } while ( n > 0);

        System.out.println(isEven(11));
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }
}

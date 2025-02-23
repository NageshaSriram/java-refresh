package org.example;

import java.sql.SQLOutput;

public class Operators {
    public static void main(String[] args) {
        int a = 10, b = 20;
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);

        if (a < b) {
            System.out.println("A is less than b");
        } else if (b < 10) {
            System.out.println();
        }

        int val = 10;

        switch (val) {
            case 1: {
                System.out.println("This is one");
                break;
            }
            case 10: {
                System.out.println("This is two");
                break;
            }
            default: {
                System.out.println("This is default");
                break;
            }
        }


    }
}

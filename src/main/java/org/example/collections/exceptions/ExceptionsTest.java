package org.example.collections.exceptions;

import java.io.*;


class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class ExceptionsTest {

    static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("The age must be more than or equal 18+");
        }
        System.out.println("You have granted access");
    }

    static void readMyFile() {
        int data;
        try (FileReader fr = new FileReader("output.txt")) {
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void readFile(String fileName) throws IOException {
        FileWriter fw = new FileWriter("output.txt");
        fw.append("Hello");
        fw.append("This is Sample text");
        fw.flush();


        FileReader fr = new FileReader(fileName);
        int data;
        while ((data = fr.read()) != -1) {
            System.out.print((char) data);
        }
        System.out.println();

        BufferedReader stringBufferedReader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = stringBufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            int a = 10 / 0;
            System.out.println(a);
        } catch (ArithmeticException ae) {
            System.out.println(ae.getMessage());
        } finally {
            System.out.println("Finally block executed");
        }
        checkAge(30);
        readFile("myFile.txt");

        try {
            throw new CustomException("This is my Custome exception");
        } catch (CustomException ce) {
            System.out.println(ce.getMessage());
        }
        readMyFile();
    }
}

package org.example.javaio;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;


class Student implements Serializable {
    int age;
    String name;
    Student(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
public class JavaIOLearning {

    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("myoutput.txt")) {
            String str = "This is my String";
            fos.write(str.getBytes());
        } catch (FileAlreadyExistsException | FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            Student student = new Student(30, "NagTej");
            System.out.println(student.age);
            System.out.println(student.name);

            objectOutputStream.writeObject(student);
            System.out.println("Object written success");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("student.ser"))) {
            Student student = (Student) objectInputStream.readObject();
            System.out.println("Read "+ student.age + " " + student.name);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}

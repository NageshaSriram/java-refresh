package org.example.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation {
    String value();
    String name();
}

class MyClass {
    private int age = 30;
    public String name = "TejNag";

    @MyAnnotation(value = "My Value", name = "My name")
    public String getAge() {
        return name;
    }
}
public class AnnotationTest {

    @MyAnnotation(value = "Custom annotation applied", name = "hello")
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        System.out.println("Hello");

        Class<?> cls = MyClass.class;

        String clsName = cls.getName();
        System.out.println(clsName);

        Class<?> myCls = MyClass.class;
        Field[] fields = myCls.getDeclaredFields();
        Arrays.stream(fields).forEach(m -> System.out.println(m.getName()));
        Method[] methods = myCls.getDeclaredMethods();
        Arrays.stream(methods).forEach(m -> System.out.println(m.getName()));

        // Dynamically call the method

        MyClass myClass = new MyClass();

        Method getAge = MyClass.class.getMethod("getAge");
        System.out.println(getAge.invoke(myClass));

        MyAnnotation myAnnotation = getAge.getAnnotation(MyAnnotation.class);
        System.out.println(myAnnotation.name());
        System.out.println(myAnnotation.value());
        System.out.println(getAge);

        Field age = MyClass.class.getDeclaredField("age");
        age.setAccessible(true);
        System.out.println(age.get(myClass));
    }
}

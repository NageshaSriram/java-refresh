package org.example.generics;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }
}

class Utils {
    public static <T> void swapValue(T[] array, Integer i, Integer j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

public class GenericTest {
    public static void main(String[] args) {
        Box<Integer> box = new Box<>(10);
        System.out.println(box.getValue());

        Box<String> boxStr = new Box<>("NagTej");
        System.out.println(boxStr.getValue());


        Integer[] arr = {1, 2, 3, 4, 5};
        Utils.swapValue(arr, 0, 4);
        System.out.println(Arrays.toString(arr));

    }
}

package org.example.threads;

import java.util.Arrays;
import java.util.List;

public class StreamsLearning {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Nagesh", "Teju", "Kulla", "Kulli");
        List<String> upperCasedNames = names.stream().map(String::toUpperCase).toList();
        System.out.println(upperCasedNames);

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        Integer sum = numbers.stream().reduce(0, Integer::max);
        System.out.println(sum);

        List<Integer> primeNumber = numbers.stream().filter(StreamsLearning::isPrimeNumber).toList();
        List<Integer> primeNumber1 = numbers.parallelStream().filter(StreamsLearning::isPrimeNumber).toList();
        System.out.println(primeNumber);
        System.out.println(primeNumber1);

    }

    public static boolean isPrimeNumber(Integer number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return  true;
    }
}

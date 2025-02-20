package LambdasStreams.Lambdas;

import java.util.*;
import java.util.stream.Collectors;

public class Client {

    public static void main(String[] args) {


        List<String> fruits = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");

        // What does the following code snippet do?
        Map<Integer, List<String>> groupedByLength = fruits.stream()
                .collect(Collectors.groupingByConcurrent(String::length));

        System.out.println(groupedByLength);

        List<String> fruits1 = List.of("apple", "banana", "orange", "grape", "kiwi");

        // What does the following code snippet do?
        String result = fruits1.stream()
                .collect(Collectors.joining(", "));

        System.out.println(result);

        

    }
}

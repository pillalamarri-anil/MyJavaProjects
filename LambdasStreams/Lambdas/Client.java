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

        List<String> fruits2 = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");

        // What does the following code snippet do?
        Set<String> uniqueFruits = fruits2.stream()
                .collect(Collectors.toSet());

        System.out.println("Result: " + uniqueFruits);


        boolean allMatch = fruits2.parallelStream()
                .allMatch(fruit -> fruit.length() > 3);

        // int[] to integer[]
        int[] intArray = {1, 2, 3, 4, 5};
        Integer[] integerArray = Arrays.stream(intArray).boxed().toArray(Integer[]::new);

        // integer[] to int[]
        Integer[] integerArray1 = {1, 2, 3, 4, 5};
        int[] intArray1 = Arrays.stream(integerArray1).mapToInt(Integer::intValue).toArray();


        List<String> sentences = Arrays.asList(
            "Java is a programming language.",
            "Python is also a good language.", 
            "Java stream processing is powerful.",
            "C++ is not as popular as Java.");


        // filter sentences that contain "Java", then map to length of each sentence, and finally calculate the average length
        int i =  (int) sentences.stream().
        filter(s->s.contains("Java")).
        mapToInt(String::length).average().orElse(0);



        List<String> sentences1 = Arrays.asList(
                "Python is a programming language.",
                "JavaScript is used for web development.",
                "Ruby is known for its simplicity.");


                long countOfUniqueWords = sentences1.stream()
                .filter(e->!e.contains("Java"))
                .flatMap(s->Arrays.stream(s.split(" ")))
                .distinct()
                .count(); 





        

    }
}

package LambdasStreams.Lambdas;

import java.util.*;
import java.util.stream.Collectors;

public class Client {

    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee( 1, "Alice", 60000, "HR" ),
                new Employee( 2, "Bob", 55000, "IT" ),
                new Employee( 3, "Charlie", 70000, "IT" ),
                new Employee( 4, "David", 45000, "Finance" ),
                new Employee( 5, "Eve", 80000, "HR" ),
                new Employee( 6, "Frank", 30000, "Finance" ),
                new Employee( 7, "Grace", 90000, "IT" )

        );

        // filter employees with salary > 50000 and get the employee with max salary
        Optional<Employee> emp1 = employees.stream().filter(emp -> emp.getSalary() > 50000).
                collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));

        // get department of the employee with max salary
        String dept = emp1.get().getDepartment();


        // get employees with max salary in EACH department
        Map<String, Optional<Employee>> departmentVsMaxSal = employees.stream().filter(emp->emp.getSalary() > 50000).collect(
                Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));


        departmentVsMaxSal.entrySet().stream().filter(e->e.getValue().isPresent()).
               max(Comparator.comparingDouble(e->e.getValue().get().getSalary()).map(e->e.getkey())).OrElse(null);


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

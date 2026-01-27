package Lamdas;

import com.sun.source.tree.Tree;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Client {

    public static void main(String[] args) {


        int[] intArr = new int[]{1,1,2,2,2,3,3,3,4,4,4};

        // Important: sort based on frequency then by value
        List<Integer> sorted = Arrays.stream(intArr).boxed().collect(Collectors.groupingBy(Function.identity(), () -> new TreeMap<>((a,b) -> (b-a)), Collectors.counting()))
                .entrySet().stream().map(e->IntStream.range(0, e.getValue().intValue()).mapToObj(i->e.getKey()))
                .flatMap(k->k).collect(Collectors.toList());


        Integer[] integerArray = Arrays.stream(intArr).boxed().toArray(Integer[]::new);

        // another way to sort based on frequency then by value
        Arrays.sort(integerArray, ( a, b) -> {
            int freqA = (int) Arrays.stream(intArr).boxed().filter(x -> x == a).count();
            int freqB = (int) Arrays.stream(intArr).boxed().filter(x -> x ==  b).count();
            if (freqA != freqB) {
                return Integer.compare(freqA, freqB);
            } else {
                return Integer.compare((Integer) b, (Integer)a);
            }
        });




        String stri = "beautifulday";

        Map<Boolean, List<Character>> partitionedStream = stri.chars().mapToObj(c -> (char)c).collect(Collectors.partitioningBy(c -> Set.of('a', 'e', 'i', 'o', 'u').contains(c)));

        // find most frequent character in a string
        String s1 = "abbcccddddeeeeeffffff";
        Optional<Character> mostFrequentChar = Optional.ofNullable(s1.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), () -> new TreeMap<Character, Long>((a,b)-> Character.compare(b, a)), Collectors.counting()))
                .entrySet().stream().findFirst().map(e -> e.getKey()).orElse( null));

        // find second most frequent character in a string
        Arrays.stream(new int[]{1,1,3,4,5}).boxed().collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().skip(1).findFirst().map(e -> e.getKey()).orElse(null);




        // remove duplicates from a string but preserve the order
        // important: distinct preserves the order of first occurrence
        String st = "banana";
        String ans1 = st.chars().mapToObj(c-> (char)c).distinct().map(c-> c.toString()).collect(Collectors.joining());

        // remove duplicates from a string but preserve the order, using LinkedHashSet
        String ans2 = st.chars().mapToObj(c->(char)c).collect(Collectors.toCollection(LinkedHashSet::new)).stream()
                .map(c->String.valueOf(c)).collect(Collectors.joining());

        // Convert List<String> to Map<String, Integer>
        List<String> words = List.of("apple", "banana", "cherry");
       Map<String, Integer> mapStrings =  words.stream().collect(Collectors.groupingBy(a -> a, Collectors.summingInt(a -> a.length())));


       // find longest string in a list
        Optional<String> ansString = Optional.ofNullable(words.stream().max((s2, s3)-> Integer.compare(s3.length(), s2.length())).orElse(null));

        // flatten a list of lists
        List<List<Integer>> data = List.of(List.of(1,2), List.of(3,4));
        List<Integer> ansData = data.stream().flatMap(list -> list.stream()).collect(Collectors.toList());

        // check if all strings start with capital letter
        boolean allStartWithCapital = words.stream().allMatch(s -> Character.isUpperCase(s.charAt(0)));




        // given a string sort the characters based on their frequency in descending order and
        // if two characters have same frequency sort them based on their natural order

        String input = "treeeeaaabbccccdddddddd";

         String  newString = input.chars().mapToObj(c-> (char)c).collect(Collectors.groupingBy(a->a, Collectors.counting()))
                 .entrySet().stream().sorted((a, b) -> (int)((b.getValue() == a.getValue()) ? a.getKey() - b.getKey() :
                 (b.getValue() - a.getValue()))).map(a -> String.valueOf(a.getKey()).repeat((int)a.getValue().intValue())).collect(Collectors.joining());

// given a string, find the 1st character that does not repeat
        String str = "swiss";
        Optional<Character> ans = Optional.ofNullable(str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(a -> a, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1L).findFirst().map(e -> e.getKey()).orElse(null));




        List<Employee> employees = List.of(
                new Employee(1, "Alice", 60000, "HR"),
                new Employee(2, "Bob", 55000, "IT"),
                new Employee(3, "Charlie", 70000, "IT"),
                new Employee(4, "David", 45000, "Finance"),
                new Employee(5, "Eve", 80000, "HR"),
                new Employee(6, "Frank", 30000, "Finance"),
                new Employee(7, "Grace", 90000, "IT")

        );

        // get the department which has the employee with  max total salary
       Optional<String> deptName = Optional.ofNullable(employees.stream().collect(Collectors.groupingBy(a -> a, Collectors.summingDouble(Employee::getSalary)))
               .entrySet().stream().max((e1, e2) -> Double.compare(e1.getValue(), e2.getValue()))
               .map(e -> e.getKey().getDepartment()).orElse(null));



                        // filter employees with salary > 50000 and get the employee with max salary
        Optional<Employee> emp1 = employees.stream().filter(emp -> emp.getSalary() > 50000).
                collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));

        // get department of the employee with max salary
        String dept = emp1.get().getDepartment();

        // Group employees by department and sort each group by salary DESC
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.collectingAndThen(Collectors.toList(),
                        list -> list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                .collect(Collectors.toList())
                )));

        // get employees with max salary in EACH department
         Map< String, List<Employee>> empoyeesByDept =  employees.stream().collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.collectingAndThen(
                Collectors.toList(), list -> list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).
                         collect(Collectors.toList())
        )));


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
        int i = (int) sentences.stream().
                filter(s -> s.contains("Java")).
                mapToInt(String::length).average().orElse(0);


        // from the sentences that contain "Java", get a list of unique words used in those sentences
        List<String> sentences1 = Arrays.asList(
                "Python is a programming language.",
                "JavaScript is used for web development.",
                "Ruby is known for its simplicity.");


        sentences1.stream().filter(a->a.contains("Java")).flatMap(a -> Arrays.stream(a.split(" "))).distinct().collect(Collectors.toList());


        List<String> uniqueWords = sentences1.stream().filter(s -> s.contains("Java")).
                flatMap( s-> Arrays.stream(s.split(" "))).distinct().collect(Collectors.toList());


        // sort a map based on its values in descendin order, if two values are same sort based on keys in descending order
        Map<String, Integer> mapColorToCount = new HashMap<>();
        mapColorToCount.put("red", 3);
        mapColorToCount.put("blue", 2);
        mapColorToCount.put("green", 1);
        mapColorToCount.put("yellow", 1);

        Map<String, Integer> mapColorToCount1 = new HashMap<>();
        mapColorToCount.put("red", 3);
        mapColorToCount.put("blue", 2);
        mapColorToCount.put("green", 1);
        mapColorToCount.put("yellow", 1);

        // consolidate two maps by summing the values for same keys
        Stream.concat(mapColorToCount.entrySet().stream(), mapColorToCount1.entrySet().stream()).
                collect(Collectors.groupingBy(a->a.getKey(), Collectors.summingInt(a->a.getValue())));

        // reduce operation
        String s =  mapColorToCount.entrySet().stream().reduce("", (a, b) -> a + b.getKey(),
                (a, b) -> a + b);


        mapColorToCount.entrySet().stream().sorted((a, b)-> (b.getValue() == a.getValue()) ? a.getKey().compareTo(b.getKey()) :
                (b.getValue() - a.getValue())).collect(Collectors.groupingBy(a->a.getKey(), TreeMap::new, Collectors.summingInt(a->a.getValue())));




    }
}

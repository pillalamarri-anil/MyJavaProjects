import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Functional {

    public static void main(String[] args) 
    {

    // Function is a functional interface that takes one argument and returns a result.
    Function<String, Integer> f = s -> s.length();
    Function<Integer, Integer> doubleFunction = n -> n * 2;

    int length = f.apply("Hello");
    System.out.println(length);

    int result = doubleFunction.apply(length);

    // Consumer is a functional interface that takes one argument and returns no result.
    Consumer<String> c = s-> System.out.println(s.toUpperCase());
    c.accept("Hello");

    BiFunction< String, Integer, String> biFunction = (s, i) -> s + i;
    String result2 = biFunction.apply("Hello", 5);
    System.out.println(result2);

    Predicate<Integer> isEven = n -> (n%2 == 0);
    isEven.test(4);

    Supplier<Integer> random = () -> (int) (Math.random() * 1000);
    random.get();


    // how do you specify timout and excetion handling in completablefuture
        CompletableFuture.supplyAsync(()-> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Result";
        }).orTimeout(1, java.util.concurrent.TimeUnit.SECONDS)
                .exceptionally(ex -> {
                    System.out.println("Exception: " + ex.getMessage());
                    return "Default Result";
                }).thenAccept(result3 -> System.out.println("Completed with: " + result3));

    }
}

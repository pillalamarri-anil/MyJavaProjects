package StreamGatherers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Gatherers;
import java.util.stream.Stream;

public class Client {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        list.stream().gather(Gatherers.windowSliding(3))
                .forEach(System.out::println);

        list.stream().gather(Gatherers.windowFixed(3)).forEach(System.out::println);

       list.stream().gather(Gatherers.windowSliding(3)).
                map(window -> window.stream().reduce(0, Integer::sum))
                .forEach(System.out::println);

    }
}

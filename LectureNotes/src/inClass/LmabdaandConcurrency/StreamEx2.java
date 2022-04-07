package inClass.LmabdaandConcurrency;

import java.util.Locale;
import java.util.stream.Stream;

public class StreamEx2 {
    public static void main(String[] args) {
//        Stream.of("d2", "a2", "c", "b1", "b3").filter(s -> {
//            System.out.println("Filter: " + s);
//            return true;
//        }).forEach(s -> System.out.println("forEach: " + s));
        Stream.of("d2", "a2", "c", "b1", "b3", "a6").filter(s -> {
            System.out.println("filter: " + s);
            return s.startsWith("a");})
                .map(s -> {
            System.out.println("map: " + s);
            return s.toUpperCase();
        })
                .forEach(s -> System.out.println("forEach: " + s));
    }
}

package inClass.LmabdaandConcurrency;

import java.util.stream.Stream;

public class StreamEx1 {
    public static void main(String[] args) {
        Stream.of("a1", "a2", "a3").findFirst().ifPresent(s -> System.out.println(s) );
        Stream.of("a4", "a2", "a3").sorted().findFirst().ifPresent(s -> System.out.println(s) );
//        Stream.of("a", "b", "c", "d").

    }
}

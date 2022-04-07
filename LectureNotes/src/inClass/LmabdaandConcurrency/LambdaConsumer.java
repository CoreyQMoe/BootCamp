package inClass.LmabdaandConcurrency;

import java.util.ArrayList;
import java.util.List;

public class LambdaConsumer {
    public static void main(String[] args) {


        List<String> names = new ArrayList<String>();
        names.add("Larry");
        names.add("Steve");
        names.add("James");
        names.add("Conan");

        names.forEach(name -> {
            System.out.println(name);
        });

        names.stream().forEach(name -> {
            System.out.println(name);
        });

        names.stream().filter(s -> s.startsWith("C") || s.startsWith("S"))
                .map(String::toUpperCase).sorted().forEach( s -> {
                    System.out.println(s);
                });
    }
}

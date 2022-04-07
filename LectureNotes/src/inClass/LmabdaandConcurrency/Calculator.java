package inClass.LmabdaandConcurrency;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Calculator {
    public Object CalcExpression(String ex) {
        List<String> expression = Arrays.asList(ex.split(""));

        IntStream.range(0, expression.size()).forEach((s) -> {
            System.out.println(s);
        });
        return null;
    }
}

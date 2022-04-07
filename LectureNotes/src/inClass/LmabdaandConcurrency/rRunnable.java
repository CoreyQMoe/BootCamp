package inClass.LmabdaandConcurrency;

import java.util.StringJoiner;

public class rRunnable {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("QuinnMoe");
        int len = str.length(); //number of characters
        int cap = str.capacity(); //full size
        System.out.println("L: " + len);
        System.out.println("Cap: " + cap);
        str.append(" The Man");
        System.out.println(str);
        str.append(1);
        System.out.println(str);

        StringJoiner joinNames = new StringJoiner(",", "[", "]");
        joinNames.add("#inc");
        joinNames.add("Monkey");
        System.out.println(joinNames);

        StringJoiner joinNames1 = new StringJoiner(":", "[", "]");
        joinNames1.add("#inc");
        joinNames1.add("Monkey");
        System.out.println(joinNames1);

        StringJoiner merge = joinNames.merge(joinNames1);
        System.out.println(merge);

//        MyFirstFunctionalInterface my = new MyFirstFunctionalInterface() {
//            @Override
//            public void firstWork() {
//                System.out.println("#inc monkey");
//            }
//        };
//        my.firstWork();
        DoIt it = new DoIt();
       // it.my.firstWork();

        sqrtimplementation sqrt = new sqrtimplementation();
        double var = sqrt.var.findsqrt(99);
        System.out.println(var);
        System.out.println(sqrt.var.findsqrt(101));

        //Lambda Expression
        SquareRootInterface sq = (n) -> (Math.sqrt(n));
        double aa = sq.findsqrt(69);
        System.out.println(aa);

      //  it.my.doSomeMoreWork1();
        //it.my.doSomeMoreWork2();

        String x = "food";
        HumanInterface a = (b) -> {
            String data = b;
            System.out.println(data);
        };
        a.eat(x);

        HumanInterface a2 = (b) -> System.out.println(b);
        a2.eat("food");

        MyFirstFunctionalInterface f = (num) -> num + 5;
        System.out.println(f.incrementByFive(64));

        StrConcat s = (str1, str2) -> str1 + str2;
        System.out.println("Result: " + s.sconcat("#inc", "monkey"));

    }
}

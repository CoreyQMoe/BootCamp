package inClass.Collections2ndHalf;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> hSet = new HashSet<>();
        Set<String> tSet = new TreeSet<>();

        HashSet gHash = new HashSet();
        gHash.add(1);
        gHash.add("Me");
        gHash.add(true);

        HashSet<String> sHash = new HashSet<>();
        sHash.add("#inc");
        sHash.add("Monkey");
        sHash.add("String");
        sHash.add(null);
        System.out.println(sHash);
        System.out.println(sHash.hashCode());

        HashSet<Integer> iHash = new HashSet<>();
        iHash.add(1);
        iHash.add(2);
        iHash.add(3);
        iHash.add(null);
        System.out.println(iHash);
        System.out.println(iHash.hashCode());

        HashSet<Integer> iHash1 = new HashSet<>();
        iHash1.add(5);
        iHash1.add(9);
        iHash1.add(69);

        iHash.addAll(iHash1);
        System.out.println(iHash);
        System.out.println(iHash1.hashCode());

        //TreeSet
        //ASC order and no nulls and no generic datatype Tree unless all the same type
        TreeSet gTree = new TreeSet();
        gTree.add(1);
        gTree.add(69);
        gTree.add(42);
        System.out.println(gTree);
        System.out.println(gTree.first());

    }
}

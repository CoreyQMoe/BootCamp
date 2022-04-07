package inClass.LmabdaandConcurrency;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    public static void main(String[] args) {

        ComparatorInterface reverser_space = (str) -> {
            String sub_str = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                sub_str += str.charAt(i);
            }
            return sub_str;
        };
        ComparatorInterface normal_noSpace = (str) -> {
            String sub_str = "";
            for (int i = 0; i < str.length(); i++) {
                String s = Character.toString(str.charAt(i));
                if (!s.equals(" ")) {
                    sub_str += s;
                }
            }
            return sub_str;
        };

        System.out.println(reverser_space.comparator("Hello class of JD"));
        System.out.println(normal_noSpace.comparator("Hello class of JD"));
    }

}

package inClass.Assignments;

import com.sun.prism.PixelFormat;

import java.util.Arrays;

public class ArrayAssignment {
    public static void main(String[] args) {
        //#1
        int[] array = {1, 2, 3};

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        //#2
        int[] array2 = {13, 5, 7, 68, 2};
        //if()
        System.out.println(array2[array2.length / 2]);

        //#3
        String[] array3 = {"red", "green", "blue", "yellow"};
        System.out.println(array3.length);
        String[] cloneArray = array3.clone();
        System.out.println(Arrays.toString(cloneArray));

        //#4
        int[] array4 = new int[5];
        for(int i = 0; i < array4.length; i++) {
            array4[i] = (int)(Math.random() * 100);
        }
        System.out.println(array4[1] + " " + array4[array4.length - 1]);
        //System.out.println(array4[array4.length]);
        //array4[5] = 9;

        //#5
        int[] array5 = new int[5];
        for(int i = 0; i < array5.length; i++) {
            array5[i] = i;
        }
        System.out.println(Arrays.toString(array5));

        //#6
        int[] array6 = new int[5];
        for(int i = 0; i < array6.length; i++) {
            array6[i] = 2 * i;
        }
        System.out.println(Arrays.toString(array6));

        //#7
        for(int i = 0; i < array6.length; i++) {
            if(i != 2) {
                System.out.println(array6[i]);
            }
        }

        //#8
        int[] array7 = new int[5];
        for(int i = 0; i < array7.length; i++) {
            array7[i] = (int)(Math.random() * 100);
        }
        int temp = array7[0];
        array7[0] = array7[array7.length/2];
        array7[array7.length/2] = temp;

        //#9
        int[] array8 = {4, 2, 9, 13, 1, 0};
        Arrays.sort(array8);
        System.out.println(Arrays.toString(array8));

        //#10
        Object[] array9 = {1, "string1", "string2", "string3", 3.14};
        System.out.println(Arrays.toString(array9));
    }
}

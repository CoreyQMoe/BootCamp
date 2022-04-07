package inClass.ArrayList;

import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList<>();// No type safety - Generic
        list1.add("#inc");
        list1.add(69);
        list1.add(true);
        list1.add(4.20);

        ArrayList<String> list2 = new ArrayList<>(); //Using type safety - Bound Type
        list2.add("monkey");

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(42);

        List<String> list4 = new ArrayList<>(); //Using hierarchy

        List list5 = Arrays.asList(12, "dude", true); //Using method

        //Tranversing Lists
        for(int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
        //for(<datatype> variable: <listName>){} - for each loop

        //Using Iterator
        Iterator itr = list1.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

        //list1.forEach(n -> System.out.println(n))  -- Lambda function


        //addAll() used to join lists
        List<Integer> list6 = new ArrayList<>();
        //list6.
        list1.addAll(list3);

        StudentController con = new StudentController();
        con.displayStudentInfo();

        TeacherController tcon = new TeacherController();
        tcon.displayTeacherInfo();

    }
}

package inClass;

import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.Scanner;

public class InClass {
//
//    public static void main(String[] args) {
//     /*   final double SALES_TAX = 0.067;
//        DecimalFormat df = new DecimalFormat("#.##");
//        double handjob = 29.99;
//        double blowjob = 59.99;
//        double anal = 99.99;
//
//        double subTotal = 3 * handjob + 4 * blowjob + 2 * anal;
//        Double total = new Double(df.format(subTotal + subTotal * SALES_TAX));
//        System.out.println(total);
//*/
//        //create object
//        System.out.println("Enter your name:");
//        Scanner input = new Scanner(System.in);
//        String name = input.nextLine();
//        System.out.println("Your name:");
//        System.out.println(name);
//
//        System.out.println("Enter your age:");
//        int age = input.nextInt();
//
//        System.out.println("Your age:");
//        System.out.println(age);
//
public static void main(String[] args) {
        // TODO Auto-generated method stub
        try{
        FileOutputStream fout=new FileOutputStream("C:\\Users\\grend\\Downloads\\TestingFolder\\writefile.txt");
        String s="Welcome to Java.";
        byte b[]=s.getBytes();//converting string into byte array
        fout.write(b);
        fout.close();
        System.out.println("success...");
        }catch(Exception e){System.out.println(e);}

    }
}

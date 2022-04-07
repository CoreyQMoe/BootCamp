package inClass.Assignments;

import java.util.Scanner;

public class Assignments {
    public static void main(String[] args) {
        //#1
        int x = 7;
        if(x < 10) {
            System.out.println("Less than 10");
        }
        x = 15;
        if(x < 10) {
            System.out.println("Less than 10");
        }

        //#2
        x = 7;
        if(x < 10) {
            System.out.println("Less than 10");
        }
        else {
            System.out.println("Greater than 10");
        }
        x = 15;
        if(x < 10) {
            System.out.println("Less than 10");
        }
        else {
            System.out.println("Greater than 10");
        }

        //#3
        if(x < 10) {
            System.out.println("Less than 10");
        }
        else if(x >= 10 && x < 20){
            System.out.println("Between 10 and 20");
        }
        else {
            System.out.println("Greater than 20");
        }
        x = 50;
        if(x < 10) {
            System.out.println("Less than 10");
        }
        else if(x >= 10 && x < 20){
            System.out.println("Between 10 and 20");
        }
        else {
            System.out.println("Greater than 20");
        }

        //#4
        x = 15;
        if(x <= 10 || x >= 20) {
            System.out.println("In range");
        }
        else{
            System.out.println("Out of range");
        }
        x = 5;
        if(x <= 10 || x >= 20) {
            System.out.println("In range");
        }
        else{
            System.out.println("Out of range");
        }

        //#5
        System.out.println("Enter number:");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number >= 90 && number <= 100) {
            System.out.println("A");
        }
        else if (number >= 80 && number <= 89) {
            System.out.println("B");
        }
        else if (number >= 70 && number <= 79) {
            System.out.println("C");
        }
        else if (number >= 60 && number <= 69) {
            System.out.println("D");
        }
        else if (number < 60) {
            System.out.println("F");
        }
        else {
            System.out.println("Out of Range");
        }

        //#6
        System.out.println("Enter number:");
        sc = new Scanner(System.in);
        number = sc.nextInt();
        switch(number) {
            case (1):
                System.out.println("Sunday");
                break;
            case (2):
                System.out.println("Monday");
                break;
            case (3):
                System.out.println("Tuesday");
                break;
            case (4):
                System.out.println("Wednesday");
                break;
            case (5):
                System.out.println("Thursday");
                break;
            case (6):
                System.out.println("Friday");
                break;
            case (7):
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Out of range");
        }
    }
}

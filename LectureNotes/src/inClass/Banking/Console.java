package inClass.Banking;

import java.util.Scanner;

public class Console {
    private Scanner sc = new Scanner(System.in);

    public void run() {
        int input;
        System.out.println("Do you have an account:");
        System.out.println("1 - Yes");
        System.out.println("2 - No");

        input = sc.nextInt();
//        sc.nextLine();

        if(input == 1) {
            this.has();
        } else if (input == 2) {
            this.open();
        } else {
            System.out.println("Incorrect Input please try again");
            this.run();
        }
    }

    private void open() {
        int input;
        System.out.println("------------------------------");
        System.out.println("What kind of account would you like to open:");
        System.out.println("1 - Checking Acccount");
        System.out.println("2 - Savings Account");
        System.out.println("3 - Privileges Account");
        System.out.println("4 - Credit Card");

        input = sc.nextInt();
//        sc.nextLine();

        switch (input) {
            case 1:
                BankAccount checking = new CheckingAccount();
                break;
            case 2:
                BankAccount savings = new SavingsAccount();
                break;
            case 3:
                BankAccount privleges = new PrivlegesAccount();
                break;
            case 4:
                BankAccount creditCard = new CreditCard();
                break;
            default:
                System.out.println("Incorrect Input please try again");
                this.open();
        }
    }

    private void has() {
        int input;
        System.out.println("------------------------------");
        System.out.println("Select an option from below:");
        System.out.println("1 - Checking Acccount");
        System.out.println("2 - Savings Account");
        System.out.println("3 - Privileges Account");
        System.out.println("4 - Credit Card");

        input = sc.nextInt();
//        sc.nextLine();

        if (input == 1) {

        } else if (input == 2) {
            System.out.println(input);
        } else if (input == 3) {
            System.out.println(input);
        } else if (input == 4) {
            System.out.println(input);
        } else {
            System.out.println("Incorrect Input please try again");
            this.has();
        }
    }
}

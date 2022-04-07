package inClass.Banking;

import java.util.Scanner;

public class SavingsAccount extends BankAccount{

    public void earnInterest(){
        super.balance += super.balance * super.interestRate;
    }

    @Override
    public void optionChosen() {
        System.out.println("------------------------------");
        System.out.println("Please choose an option for your Savings Account");
        System.out.println("1 - Check Balance");
        System.out.println("2 - Make Deposit");
        System.out.println("3 - Make Withdrawal");
        System.out.println("4 - Return to previous menu");

        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        sc.nextLine();
        if(option == 1) {
            System.out.println("Your Savings Account Balance is:");
            System.out.println(this.getBalance());
        }
        else if(option == 2) {
            System.out.println("Please enter an amount to deposit:");
            int amount = sc.nextInt();
            sc.nextLine();
            System.out.println("Making Deposit Into Savings Account");
            this.makeDeposit(amount);
            System.out.println("New Balance is:");
            System.out.println(this.getBalance());
            this.optionChosen();
        }
        else if (option == 3) {
            System.out.println("Please enter an amount to withdraw:");
            int amount = sc.nextInt();
            sc.nextLine();
            System.out.println("Making Withdrawal From Savings Account");
            this.makeWithdrawal(amount);
            System.out.println("New Balance is:");
            System.out.println(this.getBalance());
            this.optionChosen();
        }
        else {

        }
    }
}

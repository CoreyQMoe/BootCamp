package inClass.Banking;

import java.util.Date;
import java.util.Scanner;

public abstract class BankAccount {
    protected String username;
    protected int ssn;
    protected String address;
    protected static String bankName = "My Fucking Bank";
    protected static String bankAddress = "Some Address";
    protected int accountNumber;
    protected double balance;
    protected static double annualFees = 100.00;
    protected double interestRate = .05;
    protected double tax = .04;
    protected Date createDate;

    public BankAccount() {
    }

    protected BankAccount(String username, int ssn, String address, double balance) {
        this.username = username;
        this.ssn = ssn;
        this.address = address;
        this.accountNumber = (int)Math.ceil(Math.random() * 100000);
        this.balance = balance;
        this.createDate = new java.util.Date();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void makeDeposit(double amount) {
        this.balance += amount;
    }

    public void makeWithdrawal(double amount) {
        this.balance -= amount;
    }

    public abstract void optionChosen();

    public void openAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------");
        System.out.println("Enter a username:");
        this.username = sc.nextLine();
        System.out.println("Enter your Social Security Number:");
        this.ssn = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your address");
        this.address = sc.nextLine();
        System.out.println("Enter Starting Balance");
        this.balance = sc.nextDouble();
        sc.nextLine();
        System.out.println("Account has been created");
    }

    public String toString() {
        String bankAccount = new String("Account number: " + this.accountNumber + "/nBalance: " + this.balance);
        return bankAccount;
    }

}

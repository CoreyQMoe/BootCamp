package inClass.Banking;

public class CreditCard extends BankAccount{
    public void makePurchase(double amount) {
        if(balance > amount) {
            super.makeWithdrawal(amount);
        }
        else {
            System.out.println("Purchase exceeds credit limit");
        }
    }

    public void makePayment(double amount) {
        if(amount > balance) {
            System.out.println("Payment exceeds amount owed");
        }
        else {
            super.makeDeposit(amount);
        }
    }

    public double calculateAmountDue() {
        return balance;
    }

    @Override
    public void optionChosen() {

    }
}

package com.perscholas.cafe;

import java.math.BigDecimal;
import java.util.Scanner;

public class Cappuccino extends Product{
    private boolean peppermint;
    private boolean whippedCream;

    public Cappuccino() {
        this.peppermint = false;
        this.whippedCream = false;
    }

    public Cappuccino(String name, BigDecimal price, String description, boolean peppermint, boolean whippedCream) {
        super(name, price, description);
        this.peppermint = peppermint;
        this.whippedCream = whippedCream;
    }

    public boolean isPeppermint() {
        return peppermint;
    }

    public void setPeppermint(boolean peppermint) {
        this.peppermint = peppermint;
    }

    public boolean isWhippedCream() {
        return whippedCream;
    }

    public void setWhippedCream(boolean whippedCream) {
        this.whippedCream = whippedCream;
    }

    @Override
    public BigDecimal calculateProductTotal() {
        BigDecimal total = this.price;
        if(peppermint) {
            total = total.add(new BigDecimal(2));
        }
        if(whippedCream) {
            total = total.add(new BigDecimal(1));
        }
        total = total.add(this.price.multiply(new BigDecimal(this.quantity)));
        return total;
    }

    @Override
    public boolean[] addOptions() {
        boolean[] options = {false, false};
        System.out.println("Would you like peppermint? (Y/N)");
        Scanner sc = new Scanner(System.in);
        String yesOrNo = sc.nextLine();
        if(yesOrNo.equals("y") || yesOrNo.equals("Y")) {
            options[0] = true;
        }
        System.out.println("Would you like whipped cream? (Y/N)");
        yesOrNo = sc.nextLine();
        if(yesOrNo.equals("y") || yesOrNo.equals("Y")) {
            options[1] = true;
        }
        return options;
    }

    @Override
    public void printOptions() {
        if(peppermint && whippedCream) {
            System.out.println("\tPeppermint:\tYes\t(Add $2)\tWhipped Cream:\tYes\t(Add $1)");
        } else if (!peppermint && whippedCream) {
            System.out.println("\tPeppermint:\tNo\tWhipped Cream:\tYes(Add $1)");
        } else if (peppermint && !whippedCream) {
            System.out.println("\tPeppermint:\tYes\t(Add $2)\tWhipped Cream:\tNo");
        } else {
            System.out.println("\tPeppermint:\tNo\tWhipped Cream:\tNo");
        }
    }
}

package com.perscholas.cafe;

import java.math.BigDecimal;
import java.util.Scanner;

public class Coffee extends Product{
    private boolean milk;
    private boolean sugar;

    public Coffee() {
        this.milk = false;
        this.sugar = false;
    }

    public Coffee(String name, BigDecimal price, String description, boolean milk, boolean sugar) {
        super(name, price, description);
        this.milk = milk;
        this.sugar = sugar;
    }

    public boolean isMilk() {
        return milk;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    public boolean isSugar() {
        return sugar;
    }

    public void setSugar(boolean sugar) {
        this.sugar = sugar;
    }

    @Override
    public BigDecimal calculateProductTotal() {
        BigDecimal total = this.price.multiply(new BigDecimal(this.quantity));
        return this.price;
    }

    @Override
    public boolean[] addOptions() {
        System.out.println("Would you like milk in your coffee? (Y/N)");
        Scanner sc = new Scanner(System.in);
        String yesOrNo = sc.nextLine();
        boolean[] options = {false, false};
        if(yesOrNo.equals("y") || yesOrNo.equals("Y")) {
            options[0] = true;
        }
        System.out.println("Would you like sugar in your coffee? (Y/N)");
        yesOrNo = sc.nextLine();
        if(yesOrNo.equals("y") || yesOrNo.equals("Y")) {
            options[1] = true;
        }
        return options;
    }

    @Override
    public void printOptions() {
        if(milk && sugar) {
            System.out.println("\tMilk:\tYes\tSugar:\tYes");
        } else if (!milk && sugar) {
            System.out.println("\tMilk:\tNo\tSugar:\tYes");
        } else if (milk && !sugar) {
            System.out.println("\tMilk:\tYes\tSugar:\tNo");
        } else {
            System.out.println("\tMilk:\tNo\tSugar:\tNo");
        }
    }
}

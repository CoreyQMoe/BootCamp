package com.perscholas.cafe;

import java.math.BigDecimal;
import java.util.Scanner;

public class Espresso extends Product{
    private boolean extraShot;
    private boolean macchiato;

    public Espresso() {
        this.extraShot = false;
        this.macchiato = false;
    }

    public Espresso(String name, BigDecimal price, String description, boolean extraShot, boolean macchiato) {
        super(name, price, description);
        this.extraShot = extraShot;
        this.macchiato = macchiato;
    }

    public boolean isExtraShot() {
        return extraShot;
    }

    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    public boolean isMacchiato() {
        return macchiato;
    }

    public void setMacchiato(boolean macchiato) {
        this.macchiato = macchiato;
    }

    @Override
    public BigDecimal calculateProductTotal() {
        BigDecimal total = this.price;
        if(this.extraShot) {
            total = total.add(new BigDecimal(2));
        }
        if(this.macchiato) {
            total = total.add(new BigDecimal(1));
        }
        total = total.add(this.price.multiply(new BigDecimal(this.quantity)));
        return total;
    }

    @Override
    public boolean[] addOptions() {
        boolean[] options = {false, false};
        System.out.println("Would you like an extra shot of espresso? (Y/N)");
        Scanner sc = new Scanner(System.in);
        String yesOrNo = sc.nextLine();
        if(yesOrNo.equals("y") || yesOrNo.equals("Y")) {
            options[0] = true;
        }
        System.out.println("Would you like milk in your coffee? (Y/N)");
        yesOrNo = sc.nextLine();
        if(yesOrNo.equals("y") || yesOrNo.equals("Y")) {
            options[1] = true;
        }
        return options;
    }

    @Override
    public void printOptions() {
        if(extraShot && macchiato) {
            System.out.println("\tExtra Shot:\tYes\t(Add $2)\tMacchiato:\tYes\t(Add $1)");
        } else if (!extraShot && macchiato) {
            System.out.println("\tExtra Shot:\tNo\tMacchiato:\tYes\t(Add $1)");
        } else if (extraShot && !macchiato) {
            System.out.println("\tExtra Shot:\tYes\t(Add $2)\tMacchiato:\tNo");
        } else {
            System.out.println("\tExtra Shot:\tNo\tMacchiato:\tNo");
        }
    }
}

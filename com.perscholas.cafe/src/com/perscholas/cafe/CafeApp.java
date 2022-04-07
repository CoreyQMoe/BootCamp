package com.perscholas.cafe;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CafeApp {
    public static void main(String[] args) {
        final BigDecimal tax = new BigDecimal(0.05);
        Product coffee = new Coffee("Coffee", new BigDecimal(1), "Cup o' Joe", false, false);
        Product espresso = new Espresso("Espresso", new BigDecimal(2), "Wake Up Shot", false, false);
        Product cappuccino = new Cappuccino("Cappuccino", new BigDecimal(3), "Fancy Joe with Milk", false, false);


        Scanner sc = new Scanner(System.in);
//        System.out.println("How many cups of coffee would you like:");
//        coffee.setQuantity(sc.nextInt());
//        System.out.println(coffee.getName() + " " + coffee.getDescription() + " " + coffee.calculateProductTotal());
//        System.out.println();
//        System.out.println("How many shots of espresso would you like:");
//        espresso.setQuantity(sc.nextInt());
//        System.out.println(espresso.getName() + " " + espresso.getDescription() + " " + espresso.calculateProductTotal());
//        System.out.println("How many cups of cappuccino would you like:");
//        cappuccino.setQuantity(sc.nextInt());
//        System.out.println(cappuccino.getName() + " " + cappuccino.getDescription() + " " + cappuccino.calculateProductTotal());
//        BigDecimal subTotal = coffee.calculateProductTotal().add(espresso.calculateProductTotal().add(cappuccino.calculateProductTotal())).setScale(2, RoundingMode.HALF_UP);

        List<Product> cart = new ArrayList<>();
        int choice = 0;
        boolean checkout = false;
        while(!checkout) {
            boolean [] options = new boolean[2];
            System.out.println("Please select from the following:");
            System.out.println("1: Coffee");
            System.out.println("2: Espresso");
            System.out.println("3: Cappuccino");
            System.out.println("4: Check Out");
            choice = sc.nextInt();

            switch(choice) {
                case 1: options = coffee.addOptions();
                        cart.add(new Coffee(coffee.getName(), coffee.getPrice(), coffee.getDescription(), options[0], options[1]));
                    break;
                case 2: options = espresso.addOptions();
                        cart.add(new Espresso(espresso.getName(), espresso.getPrice(), espresso.getDescription(), options[0], options[1]));
                    break;
                case 3: options = cappuccino.addOptions();
                        cart.add(new Cappuccino(cappuccino.getName(), cappuccino.getPrice(), cappuccino.getDescription(), options[0], options[1]));
                    break;
                case 4: checkout = true;
                    break;
                default:
                    System.out.println("Incorrect choice. Try again.");
                    break;

            }
        }

        BigDecimal subtotal = new BigDecimal(0);
        for(int i = 0; i < cart.size(); i++) {
            subtotal = subtotal.add(cart.get(i).calculateProductTotal());
            System.out.println(i != cart.lastIndexOf(cart.get(i)));
            for(int j = 0; j <cart.size(); j++) {
                if (i != cart.lastIndexOf(cart.get(i))) {
                    cart.get(i).setQuantity(cart.get(i).getQuantity() + 1);
                    System.out.println("fuck");
                }
            }
            System.out.println("Item:\t"+cart.get(i).getName()+"\t"+"Price:\t"+cart.get(i).getPrice()+"\t"+"Qty:\t"+cart.get(i).getQuantity()+"\t"+"Subtotal:\t"+cart.get(i).calculateProductTotal());
            cart.get(i).printOptions();
        }



        System.out.println("Subtotal:\t" + subtotal);
        BigDecimal taxAmount = tax.multiply(subtotal).setScale(2, RoundingMode.HALF_UP);
        System.out.println("Tax:\t" + taxAmount);
        BigDecimal totalAfterTax = subtotal.add(taxAmount).setScale(2, RoundingMode.HALF_UP);
        System.out.println("Total:\t" + totalAfterTax);
    }
}

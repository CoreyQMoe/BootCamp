package com.example;

import java.util.concurrent.atomic.AtomicReference;

public class CartSystem extends TheSystem {
    CartSystem() {
    }

    @Override
    public void display() {
        AtomicReference<Double> subtotal = new AtomicReference<>((double) 0);
        System.out.println("Cart:");
        System.out.println(String.format("%-20s%-20s%-10s%-10s%-10s", "Name", "Description", "Price", "Quantity", "Sub Total"));
        getItemCollection().forEach((k, v) -> {
            System.out.println(String.format("%-20s%-20s%-10.2f%-10d%-10.2f", v.getItemName(), v.getItemDesc(), v.getItemPrice(), v.getQuantity(), v.getItemPrice() * v.getQuantity()));
            subtotal.updateAndGet(v1 -> new Double((double) (v1 + v.getItemPrice() * v.getQuantity())));
        });
        double pretax = subtotal.get();
        double tax = subtotal.get() * 0.05;
        double total = pretax + tax;
        System.out.println(String.format("%-20s%-20.2f", "Pre-tax Total", pretax));
        System.out.println(String.format("%-20s%-20.2f", "Tax", tax));
        System.out.println(String.format("%-20s%-20.2f", "Total", total));
    }
}
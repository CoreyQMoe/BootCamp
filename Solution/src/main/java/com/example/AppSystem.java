package com.example;

public class AppSystem extends TheSystem {
    AppSystem() {
    }

    @Override
    public void display() {
        System.out.println("APPSystem Inventory:");
        System.out.println(String.format("%-20s%-20s%-10s%-10s", "Name", "Description", "Price", "Available Quantity"));
        getItemCollection().forEach((k, v) -> System.out.println(String.format("%-20s%-20s%-10.2f%-10d", v.getItemName(), v.getItemDesc(), v.getItemPrice(), v.getAvailableQuantity())));
    }

    @Override      // this overwrites the parents class add method 
    public Boolean add(Item item) {
        boolean result;
        if(item == null) {
            result = false;
        } else if(getItemCollection().containsValue(item)) {
            result = false;
            System.out.println(item.getItemName() + "is already in the App System.");
        } else {
            result = true;
            getItemCollection().put(item.getItemName(), item);
        }
        return result;
    }

    public Item reduceAvailableQuantity(String item_name) {
        Item result = null;
        if(getItemCollection().containsKey(item_name)/* && getItemCollection().get(item_name).getAvailableQuantity() > 1*/) {
            getItemCollection().get(item_name).setAvailableQuantity(getItemCollection().get(item_name).getAvailableQuantity() - 1);
            result = getItemCollection().get(item_name);
            // if(getItemCollection().get(item_name).getAvailableQuantity() == 0) {
            //     result = null;
            // }
        }
        return result;
    }
}

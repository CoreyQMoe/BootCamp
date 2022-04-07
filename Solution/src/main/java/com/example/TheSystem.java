package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public abstract class TheSystem {
    private HashMap<String, Item> itemCollection;

    TheSystem() {
        this.itemCollection = new HashMap<String, Item>();
        if (getClass().getSimpleName().equals("AppSystem")) {
            try {
                File file = new File("resources/sample.txt");
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    String s = sc.nextLine();

                    String[] itemInfo = s.split("\\s ");

                    add(new Item(itemInfo[0], itemInfo[1], Double.parseDouble(itemInfo[2]), Integer.parseInt(itemInfo[3])));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public HashMap<String, Item> getItemCollection() {
        return itemCollection;
    }

    public Boolean checkAvailability(Item item) {
        boolean result = false;
        if (item.getQuantity() <= item.getAvailableQuantity()) {
            result = true;
        } else {
            System.out.println("System is unable to add " + item.getItemName() + " to the cart. System only has " + item.getAvailableQuantity() + " " + item.getItemName() + "s.");
        }
        return result;
    }

    public Boolean add(Item item) {
        boolean result;
        if(item == null) {
            result = false;//&& checkAvailability(item)
        } else if(this.itemCollection.containsValue(item) ) {
            result = true;
            item.setQuantity(item.getQuantity() + 1);
        } else if(!itemCollection.containsValue(item)) {
            result = true;
            itemCollection.put(item.getItemName(), item);
        } else {
            result = false;
        }
        return result;
    }

    public Item remove(String itemName) {
        return itemCollection.remove(itemName);
    }

    public void setItemCollection(HashMap<String, Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    public abstract void display();
}

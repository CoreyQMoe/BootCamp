package com.example;

public class Item{

        private String itemName;
        private String itemDesc;
        private Double itemPrice;
        private Integer quantity;
        private Integer availableQuantity;
    
    public Item(){
        this.quantity = 1;
    }
    
    public Item(String itemName, String itemDesc, Double itemPrice, Integer availableQuantity) {
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.itemPrice = itemPrice;
        this.availableQuantity = availableQuantity;
        this.quantity = 1;
    }
    
    public String getItemName() {
        return this.itemName;
    }
    
    public String getItemDesc() {
        return this.itemDesc;
    }
    
    public Double getItemPrice() {
        return this.itemPrice;
    }
    
    public Integer getAvailableQuantity() {
        return this.availableQuantity;
    }
    
    public Integer getQuantity() {
        return this.quantity;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
    
    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }
    
    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

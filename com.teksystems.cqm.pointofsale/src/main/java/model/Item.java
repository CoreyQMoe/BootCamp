package model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private double cost;
    @OneToOne
    private Department department;
    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean active;
    @ManyToOne
    private Vendor vendor;
    @Column(columnDefinition = "DATETIME DEFAULT CURDATE()")
    private LocalDateTime createdDate;
    @Column(columnDefinition = "DATETIME DEFAULT CURDATE()")
    private LocalDateTime updatedDate;

    public Item() {
    }

    public Item(int productID, String productName, String description, double price, double cost, Department department, boolean active, Vendor vendor, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.cost = cost;
        this.department = department;
        this.active = active;
        this.vendor = vendor;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
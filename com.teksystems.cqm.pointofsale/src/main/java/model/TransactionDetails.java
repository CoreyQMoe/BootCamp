package model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class TransactionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionDetailsID;
    @ManyToOne
    private Transactions transaction;
    @ManyToOne
    private Item item;
    @Column(nullable = false)
    private int quantity;
    @Column(columnDefinition = "DATETIME DEFAULT CURDATE()")
    private LocalDateTime created;
    @Column(columnDefinition = "DATETIME DEFAULT CURDATE()")
    private LocalDateTime updated;

    public TransactionDetails() {
    }

    public TransactionDetails(int transactionDetailsID, Transactions transaction, Item item, int quantity, LocalDateTime created, LocalDateTime updated) {
        this.transactionDetailsID = transactionDetailsID;
        this.transaction = transaction;
        this.item = item;
        this.quantity = quantity;
        this.created = created;
        this.updated = updated;
    }

    public int getTransactionDetailsID() {
        return transactionDetailsID;
    }

    public void setTransactionDetailsID(int transactionDetailsID) {
        this.transactionDetailsID = transactionDetailsID;
    }

    public Transactions getTransaction() {
        return transaction;
    }

    public void setTransaction(Transactions transaction) {
        this.transaction = transaction;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}

package model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iD;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Employee employee;
    private PaymentType paymentType;
    @OneToMany
    private List<TransactionDetails> details;
    @Column(columnDefinition = "DATETIME DEFAULT CURDATE()")
    private LocalDateTime created;
    @Column(columnDefinition = "DATETIME DEFAULT CURDATE()")
    private LocalDateTime updated;

    public Transactions() {
    }

    public Transactions(int iD, Customer customer, Employee employee, PaymentType paymentType, List<TransactionDetails> details, LocalDateTime created, LocalDateTime updated) {
        this.iD = iD;
        this.customer = customer;
        this.employee = employee;
        this.paymentType = paymentType;
        this.details = details;
        this.created = created;
        this.updated = updated;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public List<TransactionDetails> getDetails() {
        return details;
    }

    public void setDetails(List<TransactionDetails> details) {
        this.details = details;
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

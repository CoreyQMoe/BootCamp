package modules;

import java.util.Date;
import java.util.List;

public class Transaction {
    private String transactionNumber;
    private int customerID;
    private int employeeID;
    private List<TranscationDetail>;
    private Date createdDate;
    private Date updatedDate;

    public Transaction() {
    }

    public Transaction(String transactionNumber, int customerID, int employeeID, Date createdDate, Date updatedDate) {
        this.transactionNumber = transactionNumber;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}

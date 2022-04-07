package model;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@DynamicInsert
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeID;
    @Column(nullable = false, length = 30)
    private String firstName;
    @Column(nullable = false, length = 30)
    private String lastName;
    @Column(nullable = false, length = 30)
    private String address1;
    @Column(nullable = false, length = 30)
    private String address2;
    @Column(nullable = false, length = 30)
    private String city;
    @Column(nullable = false, length = 30)
    private String state;
    @Column(nullable = false)
    private int zipCode;
    @Column(nullable = false)
    private int phoneNumber;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean active;
    @ManyToOne
    @JoinColumn(name = "reports_to_employee_id")
    private Employee reportsTo;
    @OneToOne
    private Password password;
    @Column(columnDefinition = "DATETIME DEFAULT CURDATE()")
    private LocalDateTime createDate;
    @Column(columnDefinition = "DATETIME DEFAULT CURDATE()")
    private LocalDateTime updatedDate;

    public Employee() {
    }

    public Employee(int employeeID, String firstName, String lastName, String address1, String address2, String city, String state, int zipCode, int phoneNumber, String email, boolean active, Employee reportsTo, Password password, LocalDateTime createDate, LocalDateTime updatedDate) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.active = active;
        this.reportsTo = reportsTo;
        this.password = password;
        this.createDate = createDate;
        this.updatedDate = updatedDate;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Employee getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Employee reportsTo) {
        this.reportsTo = reportsTo;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}


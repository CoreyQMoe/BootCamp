package modules;

import java.util.Date;

public class Vendor {
    private int vendorID;
    private String vendorName;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private int zipCode;
    private int phoneNumber;
    private String repFirstName;
    private String repLastName;
    private String repEmail;
    private int repPhoneNumber;
    private boolean active;
    private Date createdDate;
    private Date updatedDate;

    public Vendor() {
    }

    public Vendor(int vendorID, String vendorName, String address1, String address2, String city, String state, int zipCode, int phoneNumber, String repFirstName, String repLastName, String repEmail, int repPhoneNumber, boolean active, Date createdDate, Date updatedDate) {
        this.vendorID = vendorID;
        this.vendorName = vendorName;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.repFirstName = repFirstName;
        this.repLastName = repLastName;
        this.repEmail = repEmail;
        this.repPhoneNumber = repPhoneNumber;
        this.active = active;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public int getVendorID() {
        return vendorID;
    }

    public void setVendorID(int vendorID) {
        this.vendorID = vendorID;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
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

    public String getRepFirstName() {
        return repFirstName;
    }

    public void setRepFirstName(String repFirstName) {
        this.repFirstName = repFirstName;
    }

    public String getRepLastName() {
        return repLastName;
    }

    public void setRepLastName(String repLastName) {
        this.repLastName = repLastName;
    }

    public String getRepEmail() {
        return repEmail;
    }

    public void setRepEmail(String repEmail) {
        this.repEmail = repEmail;
    }

    public int getRepPhoneNumber() {
        return repPhoneNumber;
    }

    public void setRepPhoneNumber(int repPhoneNumber) {
        this.repPhoneNumber = repPhoneNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

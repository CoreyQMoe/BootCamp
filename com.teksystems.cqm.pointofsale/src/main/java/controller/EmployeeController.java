package controller;

import model.Employee;
import model.Password;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;

public class EmployeeController {

    public boolean createEmployee(){
//        SessionFactory sf = new Configuration().configure().buildSessionFactory();
//        Session s = sf.openSession();
//        Transaction t = s.beginTransaction();
//
//        Employee e = new Employee();
//        e.setActive();
//        e.setAddress1();
//        e.setAddress2();
//        e.setCity();
//        e.setEmail();
//        e.setFirstName();
//        e.setLastName();
//        e.setPassword();
//        e.setPhoneNumber();
//        e.setReportsTo();
//        e.setState();
//        e.setZipCode();
//
//        s.save(e);
//        t.commit();
//        sf.close();
//        s.close();
        return false;
    }

    public boolean setEmployeeInactive(Employee e) {
        boolean result = false;
        try {
            e.setActive(false);
            e.setUpdatedDate(LocalDateTime.now());
            result = true;
        } catch (Exception ex) {
            System.out.println("Failed to set employee to inactive.");
            ex.printStackTrace();
        }
        return result;
    }

    public boolean setEmployeeActive(Employee e) {
        boolean result = false;
        try {
            e.setActive(true);
            e.setUpdatedDate(LocalDateTime.now());
            result = true;
        } catch (Exception ex) {
            System.out.println("Failed to set employee to inactive.");
            ex.printStackTrace();
        }
        return result;
    }

    public boolean changeEmployeeAddress(Employee e, String address1, String address2, String city, String state, int zip) {
        boolean result = false;
        try {
            e.setAddress1(address1);
            e.setAddress2(address2);
            e.setCity(city);
            e.setState(state);
            e.setZipCode(zip);
            e.setUpdatedDate(LocalDateTime.now());
            result = true;
        } catch (Exception ex) {
            System.out.println("Failed to change employee address.");
            ex.printStackTrace();
        }
        return result;
    }

    public boolean changeEmployeePassword(Employee e, String password){
        boolean result = false;
        try {
            e.getPassword().setPassword(password);
            e.getPassword().setUpdated(LocalDateTime.now());
            e.setUpdatedDate(LocalDateTime.now());
            result = true;
        } catch (Exception ex) {
            System.out.println("Failed to change employee password.");
            ex.printStackTrace();
        }
        return result;
    }

    public boolean changeEmployeePhoneNumber(Employee e, int phoneNumber) {
        boolean result = false;
        try {
            e.setPhoneNumber(phoneNumber);
            e.setUpdatedDate(LocalDateTime.now());
            result = true;
        } catch (Exception ex) {
            System.out.println("Failed to change employee phone number.");
            ex.printStackTrace();
        }
        return result;
    }

    public boolean changeEmployeeBoss(Employee e, Employee b) {
        boolean result = false;
        try {
            e.setReportsTo(b);
            e.setUpdatedDate(LocalDateTime.now());
            result = true;
        } catch (Exception ex) {
            System.out.println("Failed to change to whom the employee reports.");
            ex.printStackTrace();
        }
        return result;
    }

}

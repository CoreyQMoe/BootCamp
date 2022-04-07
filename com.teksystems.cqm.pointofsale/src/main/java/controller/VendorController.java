package controller;

import model.Vendor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class VendorController {
    public void createVendor() {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();

        Vendor v = new Vendor();
//        v.setAddress1();
//        v.setAddress2();
//        v.setCity();
//        v.setCity();
//        v.setPhoneNumber();
//        v.setRepEmail();
//        v.setRepFirstName();
//        v.setRepLastName();
//        v.setRepPhoneNumber();
//        v.setState();
//        v.setVendorName();
//        v.setZipCode();
//
//        s.save(v);
//        t.commit();
//        sf.close();
//        s.close();
    }
}

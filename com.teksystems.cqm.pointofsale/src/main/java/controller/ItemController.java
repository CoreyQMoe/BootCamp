package controller;

import model.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ItemController {
    public void createItem(){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();

//        Item i = new Item();
//        i.setCost();
//        i.setDepartment();
//        i.setDescription();
//        i.setPrice();
//        i.setProductName();
//        i.setVendor();
//
//        s.save(i);
//        t.commit();
//        sf.close();
//        s.close();
    }
}

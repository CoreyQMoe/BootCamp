package controller;

import model.TransactionDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TransactionDetailsController {
    public void createTransactionDetails() {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();

        TransactionDetails td = new TransactionDetails();
//        td.setItem();
//        td.setQuantity();
//        td.setTransaction();
//
//        s.save(td);
//        t.commit();
//        sf.close();
//        s.close();
    }
}

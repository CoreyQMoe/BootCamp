package controller;

import model.Transactions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TransactionController {
    public void createTransaction() {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();

        Transactions tr = new Transactions();
//        tr.setCustomer();
//        tr.setEmployee();
//
//        s.save(tr);
//        t.commit();
//        sf.close();
//        s.close();
    }
}

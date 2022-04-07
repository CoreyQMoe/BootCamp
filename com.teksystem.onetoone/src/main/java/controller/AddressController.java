package controller;

import model.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddressController {
    public void createTables() {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.close();
        sf.close();
    }

    public void insertData(){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();

        Address a1 = new Address();
        a1.setCity("New York");
        a1.setState("NY");
        a1.setStreet("69 69th St");
        a1.setZipcode(12345);

        Address a2 = new Address();
        a1.setCity("Eau Claire");
        a1.setState("WI");
        a1.setStreet("420 Water St");
        a1.setZipcode(54321);

        Address a3 = new Address();
        a3.setCity("Yo Mama");
        a3.setState("Ugly");
        a3.setStreet("No friends");
        a3.setZipcode(99999);

        s.save(a1);
        s.save(a2);
        s.save(a3);
        t.commit();

        s.close();
        sf.close();
    }
}

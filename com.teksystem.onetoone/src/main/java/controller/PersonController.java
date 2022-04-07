package controller;

import model.Address;
import model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import java.util.List;

public class PersonController {
    public void insertData(){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();

        String query = "INSERT INTO `person` (`age`, `email`, `name`, `adress_AddressId`) VALUES \n" +
                "(42, 'some@email.address', 'Sara', 1), \n" +
                "(69, 'some@gmail.com', 'Joe', 2), \n" +
                "(420, 'yahoo@gmail.com', 'Bob', 3)";
        TypedQuery tq = s.createSQLQuery(query);
        tq.executeUpdate();
        t.commit();
        s.close();
        sf.close();

    }
    public void getPersonInfo() {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        TypedQuery tq = s.createQuery("SELECT p, a FROM Person p INNER JOIN Address a on a.AddressID = p.address_AddressId");
        List<Object[]> list = tq.getResultList();
        for (Object[] e: list) {
            Person pobj = (Person) e[0];
            Address pobj1 = (Address) e[1];

            System.out.println();
        }
    }
}

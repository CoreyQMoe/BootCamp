package com.test.controller;

import com.test.hib.controller.CreatingUser;
import com.test.hib.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import javax.persistence.TypedQuery;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CreateUserTest {
    static SessionFactory sf;
    static Session s;

    @BeforeAll
    public static void setup() {
        sf = new Configuration().configure().buildSessionFactory();
        s = sf.openSession();
    }

    @Test
    public void wtf() {
//        sf = new Configuration().configure().buildSessionFactory();
//        s = sf.openSession();
        CreatingUser u = new CreatingUser();
        u.createUserTable();
        String q = "SELECT u FROM User u";
        TypedQuery tq = s.createQuery(q);
        List<Object[]> results = tq.getResultList();
        assertTrue(results.size() > 0);
    }

    @AfterAll
    public static void cleanup() {
        if(sf != null) {
            sf.close();
        }
        if(s != null) {
            s.close();
        }
    }
}

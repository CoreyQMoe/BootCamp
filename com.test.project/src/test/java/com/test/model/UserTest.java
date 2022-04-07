package com.test.model;

import com.test.hib.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserTest {
    static SessionFactory sf;
    static Session s;
    static User actual;
    @BeforeAll
    public static void setup() {
        sf = new Configuration().configure().buildSessionFactory();
        s = sf.openSession();
    }

    @BeforeEach
    public void setupEach() {
        actual = new User("CQ", "cq@mail.com", "password", 42, 100, "city");
    }

    @Test
    public void testGetFullName() {

        assertEquals("CQ", actual.getFullname());
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

package com.coreymoe.heroespos;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Runner {
    public Runner() {
    }

    public static void main(String[] args) {
        SessionFactory sf = (new Configuration()).configure().buildSessionFactory();
        Session s = sf.openSession();
        s.close();
        sf.close();
    }
}

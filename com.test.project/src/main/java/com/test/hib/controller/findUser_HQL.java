package com.test.hib.controller;

import com.test.hib.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.TypedQuery;
import java.util.Iterator;
import java.util.List;

public class findUser_HQL {
    public void findAllUser() {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();

        String hql = "From User"; //String hql = "SELECT u User u";
        TypedQuery query = s.createQuery(hql);
        List<User> ulist = query.getResultList();
        for (User u :ulist) {
            System.out.println("user id: " + u.getId() + " user name: " + u.getFullname() + " user city: " + u.getCity() + " user salary: " + u.getSalary());
        }
        sf.close();
        s.close();
    }

    public void getRecordByID() {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        String hql = "SELECT u FROM User u WHERE u.id < 3 ORDER BY u.id DESC";
        TypedQuery query = s.createQuery(hql);
        List<User> userList = query.getResultList();
        for (User u :userList) {
            System.out.println("user id: " + u.getId() + " user name: " + u.getFullname() + " user city: " + u.getCity() + " user salary: " + u.getSalary());
        }
        sf.close();
        s.close();
    }

    public void getMaxSalary() {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        String hql = "SELECT MAX(u.salary) FROM User u";
        TypedQuery query = s.createQuery(hql);
        double var = (Double)query.getSingleResult();
        System.out.println(var);
        sf.close();
        s.close();
    }

    public void getAllUsers(int userid){
        //Demo of parameterized query also called prepared statements
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        String hql = "SELECT u FROM User u WHERE u.id = :userid";
        TypedQuery query = s.createQuery(hql);
        query.setParameter("userid", userid);
        List<User> userList = query.getResultList();
        for (User u :userList) {
            System.out.println("user id: " + u.getId() + " user name: " + u.getFullname() + " user city: " + u.getCity() + " user salary: " + u.getSalary());
        }
        sf.close();
        s.close();
    }

    public void getUsersData() {//Third rule
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        String hql = "SELECT u.fullname, u.email FROM User u";
        TypedQuery q = s.createQuery(hql);
        List<Object[]> a = q.getResultList();
//        for(Object[] e: a) {
//            System.out.println(e[0] + " " + e[1]);
//        }
        for(Iterator it = a.iterator(); it.hasNext();) {

        }
    }
}
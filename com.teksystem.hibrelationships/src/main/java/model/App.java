package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		MyController c = new MyController();
		c.createaManyToOne();
		c.insertRecord();
	}

}

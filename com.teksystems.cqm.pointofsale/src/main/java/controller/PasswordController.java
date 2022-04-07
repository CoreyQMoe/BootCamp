package controller;

import model.Employee;
import model.Password;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.Duration;
import java.time.LocalDateTime;

public class PasswordController {

    public boolean checkForPasswordChangeNeeded(Employee e) {
        boolean result = false;
        try {
            LocalDateTime lastUpdated = e.getPassword().getUpdated();
            Duration duration = Duration.between(lastUpdated, LocalDateTime.now());
            if (duration.toDays() >= 90) {
                result = true;
            }
        } catch (Exception ex) {
                System.out.println("Failed to compare last time the password was changed to today.");
                ex.printStackTrace();
        }
        return result;
    }
}

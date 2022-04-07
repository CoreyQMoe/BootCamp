package javadatabaseconnectivity.JDBC;

import sun.security.util.Password;

import java.sql.*;

public class Runnable {

    static final String USER = "root";
    static final String PASS = "Password";//new Password().pass; // just to protect my password, this can just be "password"
    static final String url = "jdbc:mariadb://localhost/classicmodels";
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Connecting to database...");
            Connection conn = DriverManager.getConnection(url, USER, PASS);
            System.out.println("Successfully connected to database at: " + url);
            System.out.println("Retrieving information from database...");
            Statement stmt = conn.createStatement();
            String SelectSQL = "SELECT * FROM employees";
            ResultSet result =  stmt.executeQuery(SelectSQL);
            System.out.println("Query Successful, data below: ");
            while(result.next())
            {
                String name = result.getString("firstName");
                String email  = result.getString("email");
                System.out.println(name +" | " + email);
            }
            // Use PreparedStatement to protect against SQL dependency injection attacks
            // improved performance
            // pre-complies the SQL statements

            // The "?" is a parameter placeholder. Use the PreparedStatement methods to set the parameters.
            String sql1 = "SELECT * FROM employees WHERE firstName = ?";
            PreparedStatement prepStmt = conn.prepareStatement(sql1);
            // The 1st string parameter is set to "Martin"
            prepStmt.setString(1, "Martin");

            // Display employees where firstName >= Martin
            result =  prepStmt.executeQuery();
            System.out.println("Query Successful, data below: Martin ");
            while(result.next())
            {
                String name = result.getString("firstName");
                String email  = result.getString("email");
                System.out.println(name +" | " + email);
            }

            // Now the 1st string parameter is set to "William"
            prepStmt.setString(1, "William");

            // Display employees where firstName >= William
            result =  prepStmt.executeQuery();
            System.out.println("Query Successful, data below: William");
            while(result.next())
            {
                String name = result.getString("firstName");
                String email  = result.getString("email");
                System.out.println(name +" | " + email);
            }
        }
        catch (SQLException se) { // Handles DB Connection Errors
            se.printStackTrace();
        }
        catch (Exception e) { // Handles Class.forName errors ie: class not found exception. This is caused by not having the JAR for maria
            e.printStackTrace();
        }


    }
}

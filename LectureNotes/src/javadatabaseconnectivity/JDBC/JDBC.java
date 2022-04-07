package javadatabaseconnectivity.JDBC;

import java.sql.*;

public class JDBC {
    public static void main(String[] args) throws Exception {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver()); //Method 1
        Class.forName("org.mariadb.jdbc.Driver"); //Method 2

        Class.forName("org.mariadb.jdbc.Driver");
        String url = "jdbc:mariadb://localhost/classicmodels";
        final String USER = "root";
        final String PASS = "Password";
        Connection conn = DriverManager.getConnection(url, "root", "Password");

        String SelectSQL = "SELECT * FROM employees";
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(SelectSQL);


    }
}

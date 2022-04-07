package OOP_JDBC;

import java.sql.*;

public class AbstractDAO implements EmployeeDAOI {
    private final String user = "root";
    private final String password = "Password"; // PUT YOUR PASSWORD HERE
    private final String port = "3306"; // PUT YOUR PORT HERE. default is "3306", but use "3305" if you already had mySQL
    private final String database = "classicmodels";
    private final String url = "jdbc:mariadb://localhost:" + port + "/" + database;
    private final Driver driver = new oracle.jdbc.driver.OracleDriver();

    protected Connection conn = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;

    public void connect() throws SQLConnectionException {
        try {
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new SQLConnectionException(e.getMessage(), url, user, password);
        }
    }

    public void dispose() {
        try {
            if (!rs.equals(null)) {
                if (!rs.isClosed()) rs.close();
            }
            if (!ps.equals(null)) {
                if (!ps.isClosed()) ps.close();
            }
            if (!conn.equals(null)) {
                if (!conn.isClosed()) conn.close();
            }
        }
        catch (SQLException e) {
        }
    }
    public Employee getEmployeeById(int id) {
        Employee employee = new Employee();
        try {
            this.connect();
            ps = conn.prepareStatement(SQL.GET_EMPLOYEE_BY_ID.getQuery());
            ps.setInt(1,  id);
            rs = ps.executeQuery();
            if(rs.next()) {
// these methods retrieve data from the database. the number in the argument corresponds to the column number in the database, so column #5 is the employee email.
                employee.setId(rs.getInt(1));
                employee.setEmail(rs.getString(5));
                employee.setfName(rs.getString(3));
                employee.setlName(rs.getString(2));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (SQLConnectionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            this.dispose();
        }
        return employee;
    }
}

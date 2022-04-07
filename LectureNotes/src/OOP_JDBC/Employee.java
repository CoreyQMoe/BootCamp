package OOP_JDBC;

public class Employee {

    int employeeNumber;
    String lastName;
    String firstName;
    String email;

    public String toString() {
        return employeeNumber + " " + firstName + " " + lastName + " " + email;
    }

    public void setId(int employeeNumber) {
        // TODO Auto-generated method stub
        this.employeeNumber = employeeNumber;
    }

    public void setEmail(String email) {
        // TODO Auto-generated method stub
        this.email = email;
    }

    public void setfName(String firstName) {
        // TODO Auto-generated method stub
        this.firstName = firstName;
    }

    public void setlName(String lastName) {
        // TODO Auto-generated method stub
        this.lastName = lastName;
    }
}

package OOP_JDBC;

public class DAODriver {

    public static void main(String[] args) {

        AbstractDAO myDAO = new AbstractDAO();
        try {
            System.out.println("opening connection");
            myDAO.connect();

            System.out.println("query");
            Employee myResult = myDAO.getEmployeeById(1002);
            System.out.println(myResult.toString());

            System.out.println("closing connection");
            myDAO.dispose();

        } catch (SQLConnectionException e) {
            e.printStackTrace();
        }

        System.out.println("program end");
    }
}

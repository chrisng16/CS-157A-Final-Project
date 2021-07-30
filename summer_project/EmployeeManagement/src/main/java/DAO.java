
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
    private String jdbcUsername = "system";
    private String jdbcPassword = "oracle";

    private static final String INSERT_EMPLOYEE = "INSERT INTO employee VALUES (?,?,?,?,?);";

    private static final String SELECT_EMPLOYEE = "SELECT employeeid, name, salary FROM employee WHERE name = ?";
    private static final String SELECT_ALL_USERS = "select * from employee";
    
    public DAO() {}

    /*
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    */


    public void insertEmployee(Employee employee) throws SQLException {
        System.out.println(INSERT_EMPLOYEE);
       
        try {
        	Connection connection = DBConnect.getConnection(); 
    		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setInt(3, 0);
            preparedStatement.setInt(4, employee.getSalary());
            preparedStatement.setInt(5, 0);
            //System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            connection.commit();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            //printSQLException(e);
        }
        
    }

    public Employee selectEmployee(String n) {
    	Employee employee = new Employee();
        try {
        	Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE);
            preparedStatement.setString(1, n);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            employee.setName(rs.getString("name"));
            employee.setId(rs.getInt("employeeid"));
            employee.setSalary(rs.getInt("salary"));
            preparedStatement.executeUpdate();
            connection.commit();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            //printSQLException(e);
        }
        
        return employee;
    }

    public List < Employee > selectAllUsers() {

        List < Employee > employees = new ArrayList < > ();
        
        try (Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	int employeeid = rs.getInt("employeeid");
                String name = rs.getString("name");
                //int hours = rs.getInt("hoursworked");
                int salary = rs.getInt("salary");
                employees.add(new Employee(employeeid, name, salary));
            }
            connection.commit();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            //printSQLException(e);
        }
        
        
        
        return employees;
    }
   
}

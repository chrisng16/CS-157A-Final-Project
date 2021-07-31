package project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	
    private String host = "localhost";
    private int port = 1521;
    private String dbName = "xe";
    private String dbURL = "jdbc:oracle:thin:@" + host + ":" + port + ":" + dbName;

    private String username = "system";
    private String password = "password";
    
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO EMPLOYEE VALUES (?,?,?)";
    private static final String SELECT_ALL_EMPLOYEES_SQL = "SELECT * FROM EMPLOYEE";
    
    public EmployeeDAO() {
    	Connection connection = getConnection();
    	try {
    		String query = "CREATE TABLE EMPLOYEE (ID NUMBER(3) PRIMARY KEY, NAME VARCHAR2(50) NOT NULL, SALARY NUMBER(6) NOT NULL)";
			Statement s = connection.createStatement();
			s.execute(query);
			System.out.println("TABLE CREATED!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    protected Connection getConnection() {
    	Connection connection = null;
    	try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException e) {
			System.out.println("Connection error: " + e);
		} catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading driver: " + cnfe);
		}
        return connection;
    }
    
    public void insertEmployee(Employee employee) throws SQLException {
    	System.out.println(INSERT_EMPLOYEE_SQL);
    	
    	try(Connection connection = getConnection();
    		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL);) {
    		
    		preparedStatement.setInt(1, employee.id);
    		preparedStatement.setString(2, employee.name);
    		preparedStatement.setDouble(3, employee.salary);
    		
    		System.out.println(preparedStatement);
    		preparedStatement.executeUpdate();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public List<Employee> selectAllEmployees(){
    	List<Employee> employees = new ArrayList<Employee>();
    	try (Connection connection = getConnection();
    	     PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES_SQL);) {
    	            
    		 System.out.println(preparedStatement);
    		 ResultSet rs = preparedStatement.executeQuery();

    		 while (rs.next()) {
    			 int id = rs.getInt("id");
    			 String name = rs.getString("name");
    			 double salary = rs.getDouble("salary");
    			 employees.add(new Employee(id, name, salary));
    		 }
    	 } catch (SQLException e) {
    		 e.printStackTrace();;
    	 }
    	return employees;
    }
}

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:XE";
    private final String jdbcUsername = "system";
    private final String jdbcPassword = "oracle";

    public DAO() {}

    public void insertEmployee(Employee employee) throws SQLException {
        try {
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setInt(3, employee.getHoursworked());
            preparedStatement.setInt(4, employee.getSalary());
            preparedStatement.setInt(5, employee.getProjectedpay());
            preparedStatement.executeUpdate();
            System.out.println("Added to database.");
        } catch (SQLException e) {
            System.out.println("Unable to connect to database.");
        }

    }

    public Employee selectEmployee(String n) {
        Employee employee = new Employee();
        try {
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE name = ?");
            preparedStatement.setString(1, n);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
               employee.setName(rs.getString("name"));
               employee.setId(rs.getInt("employeeid"));
               employee.setHoursworked(rs.getInt("hoursworked"));
               employee.setSalary(rs.getInt("salary"));
               employee.setProjectedpay();
            }
            //System.out.println(employee.getName() + " " + employee.getId() + " " + employee.getHoursworked());		//debug
        } catch (SQLException e) {
            //printSQLException(e);
        }
        return employee;
    }

    public List <Employee> selectAllEmployees() {
        List <Employee> employees = new ArrayList < > ();

        try (Connection connection = DBConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from employee")) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int employeeid = rs.getInt("employeeid");
                String name = rs.getString("name");
                int hours = rs.getInt("hoursworked");
                int salary = rs.getInt("salary");
                employees.add(new Employee(employeeid, name, hours, salary));
            }

        } catch (SQLException e) {
            //printSQLException(e);
        }

        return employees;
    }

}




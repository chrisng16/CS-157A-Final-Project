import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    protected static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            System.out.print("out");

            String dbURL = "jdbc:oracle:thin:@localhost:1521:XE";
            String username = "system";
            String password = "oracle";

            connection = DriverManager.getConnection(dbURL, username, password);

            System.out.print("out");

            DatabaseMetaData dbMetaData = connection.getMetaData();
            String productName =dbMetaData.getDatabaseProductName();
            System.out.println("Database: " + productName);
            String productVersion =dbMetaData.getDatabaseProductVersion();
            System.out.println("Version: " + productVersion);
        } catch (Exception e) {}

        return connection;

    }

}

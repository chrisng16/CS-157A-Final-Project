import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class productDAO {
    public productDAO(){
    }

    public void insertProduct(Product product) throws SQLException {
        try {
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO item VALUES (?,?,?,?,?,? )");
            preparedStatement.setInt(1, product.getProductID());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, product.getCategory());
            preparedStatement.setInt(4, product.getPrice());
            preparedStatement.setInt(5, product.getRating());
            preparedStatement.setString(6, product.getManufacturer());
            preparedStatement.executeUpdate();
            System.out.println("Added to database.");
        } catch (SQLException e) {
            System.out.println("Unable to connect to database.");
        }

    }

    public Product selectProduct(String n, boolean name) {
        Product product = new Product();
        String search = "SELECT * FROM item WHERE productid = ?";
        if(name)
            search = "SELECT * FROM item WHERE name = ?";

        try {
            Connection connection = DBConnect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(search);
            preparedStatement.setString(1, n);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                product.setName(rs.getString("name"));
                product.setProductID(rs.getInt("productid"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getInt("price"));
                product.setRating(rs.getInt("rating"));
            }
        } catch (SQLException e) {
            //printSQLException(e);
        }

        return product;
    }
}

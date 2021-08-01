import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private productDAO dao;

    public void init() {
        dao = new productDAO();
    }

    public ProductServlet () {
        super();
    }

    /**
     * The doPost method is for receiving data from the front end to store in the db.
     * @param request Request from the front end
     * @param response Response sent from the back end to the front-end.
     */
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get current session for sending responses to front-end
        HttpSession session = request.getSession();

        // Parameters received from the front end
        String name = request.getParameter("name");
        String id1 = request.getParameter("id");
        String category = request.getParameter("category");
        String price1 = request.getParameter("price");
        String rating1 = request.getParameter("rating");
        String manufacturer = request.getParameter("manufacturer");
        int id = Integer.parseInt(id1);
        int price = Integer.parseInt(price1);
        int rating = Integer.parseInt(rating1);
        
        Product newProd = new Product(id, name, category, price, rating, manufacturer);
        try {
            dao.insertProduct(newProd);
            // Build and send a response to the front-end to verify that the item was received.
            String resp = name + " was added to the database.";
            session.setAttribute("response", resp);
            RequestDispatcher rd = request.getRequestDispatcher("/addProduct.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            String error = e.getMessage();
            String resp = "Unable to add " + name + " to the database. Error = " + error;
            session.setAttribute("response", resp);
            RequestDispatcher rd = request.getRequestDispatcher("/addProduct.jsp");
            rd.forward(request, response);
        }

        //TODO add inputs to database
    }


    /**
     * The doGet method is for sending data from the db to the front-end for displaying to the user.
     * @param request Request from the front-end.
     * @param response Response from the back-end.
     */
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get current session for sending responses to front-end
        HttpSession session = request.getSession();

        // Received from the name field on the web page. Add more strings as needed. "name" is the variable that
        // is sent by the front-end. If user types in "John", name contains John.
        String req = request.getParameter("name");
        boolean name=true;

        if(req!=null) {
            //TODO get requested info from db to return to front-end
            Product product = dao.selectProduct(req, name);

            String productInfo = "<br>Product Name : " + product.getName() + " <br> Product ID : " + product.getProductID() +
                    " <br> Category : " + product.getCategory() + "<br> Price :  " + product.getPrice() + "<br> Rating : "
                    + product.getRating() + "<br>Manufacturer : " + product.getManufacturer();

            // Sends the data to the front-end
            session.setAttribute("list", productInfo);
            RequestDispatcher rd = request.getRequestDispatcher("/searchProduct.jsp");
            rd.forward(request, response);
        }
        else{
            name = false;
            String idSearch = request.getParameter("id");
            Product product = dao.selectProduct(idSearch, name);

            String productInfo = "<br>Product Name : " + product.getName() + " <br> Product ID : " + product.getProductID() +
                    " <br> Category : " + product.getCategory() + "<br> Price :  " + product.getPrice() + "<br> Rating : "
                    + product.getRating() + "<br>Manufacturer : " + product.getManufacturer();

            // Sends the data to the front-end
            session.setAttribute("list", productInfo);
            RequestDispatcher rd = request.getRequestDispatcher("/searchProduct.jsp");
            rd.forward(request, response);
        }

    }
}

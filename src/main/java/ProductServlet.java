import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ProductServlet () {
        super();
    }

    /**
     * The doPost method is for receiving data from the front end to store in the db.
     * @param request Request from the front ed
     * @param response Response sent from the back end to the front-end.
     */
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get current session for sending responses to front-end
        HttpSession session = request.getSession();

        // Parameters received from the front end
        String name = request.getParameter("name");
        String partNum = request.getParameter("partNum");
        String price = request.getParameter("price");

        // Debugging stuff
        String all = "\n" + name + " " +partNum + " " +price;
        System.out.println(all);

        // Build and send a response to the front-end to verify that the item was received.
        String resp = name + " was added to the database.";
        session.setAttribute("response", resp);
        RequestDispatcher rd = request.getRequestDispatcher("/addProduct.jsp");
        rd.forward(request, response);

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
        // is sent by the front-end. If user types in "Widget", name contains widget.
        String req = request.getParameter("name");

        //TODO get requested info from db to return to front-end

        // Hard-coded data to test sending data from back-end to front-end.
        ArrayList<String> list = new ArrayList<>();
        list.add("Widget");
        list.add("Thing");
        list.add("What-cha-ma-call-it");

        // Sends the data to the front-end
        session.setAttribute("list", list);
        RequestDispatcher rd = request.getRequestDispatcher("/searchProduct.jsp");
        rd.forward(request,response);

    }
}

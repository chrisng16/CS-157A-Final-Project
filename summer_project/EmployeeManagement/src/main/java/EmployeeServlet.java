import javax.servlet.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private DAO dao;
    
    public void init() {
        dao = new DAO();
    }
    
    public EmployeeServlet() {
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
        String idS = request.getParameter("id");
        String salaryS = request.getParameter("salary");
        int id = Integer.valueOf(idS);
        int salary = Integer.valueOf(salaryS);
        
        // Debugging stuff
        String all = "\n" + name + " " +id + " " +salary;
        System.out.println(all);

        //TODO add inputs to database
        
        Employee newEmp = new Employee(id, name, salary);
        try {
			dao.insertEmployee(newEmp);
			// Build and send a response to the front-end to verify that the item was received.
            String resp = name + " was added to the database.";
            session.setAttribute("response", resp);
            RequestDispatcher rd = request.getRequestDispatcher("/addEmployee.jsp");
            rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
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

        //TODO get requested info from db to return to front-end
        Employee emp = dao.selectEmployee(req);

        /*
        // Hard-coded data to test sending data from back-end to front-end.
        ArrayList<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("Jane");
        list.add("Harry");
        */
        
        String employeeInfo = emp.getName() + " " + emp.getId() + " " + emp.getSalary();
        
        // Sends the data to the front-end
        session.setAttribute("list", employeeInfo);
        RequestDispatcher rd = request.getRequestDispatcher("/searchEmployee.jsp");
        rd.forward(request,response);

    }
    
    private void doListEmployees(HttpServletRequest request, HttpServletResponse response)
    	    throws IOException, ServletException {
    			List<Employee> listEmployees = dao.selectAllUsers();
    			request.setAttribute("listEmployees", listEmployees);
    			RequestDispatcher dispatcher = request.getRequestDispatcher("employeeList.jsp");
    	        dispatcher.forward(request, response);
    	    }
}


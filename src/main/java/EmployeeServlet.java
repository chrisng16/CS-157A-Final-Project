import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
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
        String idS = request.getParameter("empID");
        String salaryS = request.getParameter("salary");
        String hoursS = request.getParameter("hours");
        int id = Integer.parseInt(idS);
        int salary = Integer.parseInt(salaryS);
        int hours = Integer.parseInt(hoursS);

        // Debugging stuff
        String all = "\n" + name + " " +id + " " + hours + " " + salary;
        System.out.println(all);

        //TODO add inputs to database

        Employee newEmp = new Employee(id, name, hours, salary);
        try {
            dao.insertEmployee(newEmp);
            // Build and send a response to the front-end to verify that the item was received.
            String resp = name + " was added to the database.";
            session.setAttribute("response", resp);
            RequestDispatcher rd = request.getRequestDispatcher("/addEmployee.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            String error = e.getMessage();
            String resp = "Unable to add " + name + " to the database. Error = " + error;
            session.setAttribute("response", resp);
            RequestDispatcher rd = request.getRequestDispatcher("/addEmployee.jsp");
            rd.forward(request, response);
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

        String action = request.getServletPath();
        
        // Get current session for sending responses to front-end
        HttpSession session = request.getSession();

        // Received from the name field on the web page. Add more strings as needed. "name" is the variable that
        // is sent by the front-end. If user types in "John", name contains John.
        String req = request.getParameter("name");

        //TODO get requested info from db to return to front-end
        Employee emp = dao.selectEmployee(req);

        String employeeInfo = "<br>Employee Name : " + emp.getName() + " <br> Employee ID : " + emp.getId() + " <br> Hours Worked : "
                + emp.getHoursworked() + "<br> Salary :  " + emp.getSalary() + "<br> Projected Pay : "
                + emp.getProjectedpay();

        // Sends the data to the front-end
        session.setAttribute("list", employeeInfo);
        RequestDispatcher rd = request.getRequestDispatcher("/searchEmployee.jsp");
        rd.forward(request,response);


    }

    protected void listEmployees(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<Employee> listEmployees = dao.selectAllEmployees();
        request.setAttribute("listEmployees", listEmployees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employeeList.jsp");
        dispatcher.forward(request, response);
    }

}
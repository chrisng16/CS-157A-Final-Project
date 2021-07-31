package project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO employeeDAO;
       
    public void init() {
    	employeeDAO = new EmployeeDAO();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
				case "/insert":
					insertUser(request, response);
					break;
				case "/listEmployee":
					listEmployees(request, response);
					break;
				default:
					break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
		String name = "";
		int id = 0;
		double salary = 0;
		
		try {
			name = request.getParameter("name");
			id = Integer.valueOf(request.getParameter("id"));
			salary = Double.valueOf(request.getParameter("salary"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Employee newEmployee = new Employee(id,name,salary);
		employeeDAO.insertEmployee(newEmployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
		dispatcher.forward(request,response);
	}

	private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<Employee> employeeList = employeeDAO.selectAllEmployees();
		request.setAttribute("employeeList", employeeList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
		dispatcher.forward(request, response);
	}
}

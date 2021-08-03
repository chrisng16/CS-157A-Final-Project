package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.Employee;
import employee.EmployeeDAO;
import product.Product;
import product.ProductDAO;

@WebServlet("/")
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAO employeeDAO;
	private ProductDAO productDAO;

	public void init() {
		employeeDAO = new EmployeeDAO();
		productDAO = new ProductDAO();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/insert_employee":
				insertEmployee(request, response);
				break;
			case "/new_employee":
				showAddEmployeeForm(request, response);
				break;
			case "/delete_employee":
				deleteEmployee(request, response);
				break;
			case "/edit_employee":
				showEditEmployeeForm(request, response);
				break;
			case "/update_employee":
				updateEmployee(request, response);
				break;
			case "/search_employee":
				searchEmployee(request, response);
				break;
			case "/search_product":
				searchProduct(request, response);
				break;
			case "/insert_product":
				insertProduct(request, response);
				break;
			case "/new_product":
				showAddProductForm(request, response);
				break;
			case "/delete_product":
				deleteProduct(request, response);
				break;
			case "/edit_product":
				showEditProductForm(request, response);
				break;
			case "/update_product":
				updateProduct(request, response);
				break;
			case "/list_product_customer":
				listProductsCustomer(request, response);
				break;
			case "/list_product_admin":
				listProductsAdmin(request, response);
				break;
			case "/list_employee":
				listEmployees(request, response);
				break;
			default:
				listEmployees(request, response);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Product temp = productDAO.selectProduct(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("show-searched-product.jsp");
		request.setAttribute("searched_product", temp);
		dispatcher.forward(request, response);
	}

	private void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Employee temp = employeeDAO.selectEmployee(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("show-searched-employee.jsp");
		request.setAttribute("searched_employee", temp);
		dispatcher.forward(request, response);
	}

	private void showEditProductForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Product temp = productDAO.selectProduct(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("insert-edit-product.jsp");
		request.setAttribute("product", temp);
		dispatcher.forward(request, response);
	}

	private void updateProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));

		Product temp = new Product(id, name, price);
		productDAO.updateProduct(temp);
		response.sendRedirect("list_product");
	}

	private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		productDAO.deleteProduct(id);
		response.sendRedirect("list_product");
	}

	private void showAddProductForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("insert-edit-product.jsp");
		dispatcher.forward(request, response);
	}

	private void insertProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String name = "";
		int id = 0;
		double price = 0;

		try {
			name = request.getParameter("name");
			id = Integer.valueOf(request.getParameter("id"));
			price = Double.valueOf(request.getParameter("price"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		Product newProduct = new Product(id, name, price);
		productDAO.insertProduct(newProduct);
		response.sendRedirect("list_product");
	}

	private void listProductsAdmin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Product> productList = productDAO.selectAllProducts();
		request.setAttribute("productList", productList);
		for (Product e : productList) {
			System.out.println(e);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("product-list-admin.jsp");
		dispatcher.forward(request, response);
	}
	
	private void listProductsCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Product> productList = productDAO.selectAllProducts();
		request.setAttribute("productList", productList);
		for (Product e : productList) {
			System.out.println(e);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("product-list-customer.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditEmployeeForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Employee temp = employeeDAO.selectEmployee(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("insert-edit-employee.jsp");
		request.setAttribute("employee", temp);
		dispatcher.forward(request, response);
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String name = "";
		int id = 0;
		double salary = 0;
		double hoursWorked = 0;

		try {
			name = request.getParameter("name");
			id = Integer.parseInt(request.getParameter("id"));
			salary = Double.parseDouble(request.getParameter("salary"));
			hoursWorked = Double.valueOf(request.getParameter("hoursWorked"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Employee temp = new Employee(id, name, salary, hoursWorked);
		employeeDAO.updateEmployee(temp);
		response.sendRedirect("list_employee");
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		employeeDAO.deleteUser(id);
		response.sendRedirect("list_employee");
	}

	private void showAddEmployeeForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("insert-edit-employee.jsp");
		dispatcher.forward(request, response);
	}

	private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String name = "";
		int id = 0;
		double salary = 0;
		double hoursWorked = 0;

		try {
			name = request.getParameter("name");
			id = Integer.parseInt(request.getParameter("id"));
			salary = Double.parseDouble(request.getParameter("salary"));
			hoursWorked = Double.valueOf(request.getParameter("hoursWorked"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Employee newEmployee = new Employee(id, name, salary, hoursWorked);
		employeeDAO.insertEmployee(newEmployee);
		response.sendRedirect("list_employee");
	}

	private void listEmployees(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Employee> employeeList = employeeDAO.selectAllEmployees();
		request.setAttribute("employeeList", employeeList);
		for (Employee e : employeeList) {
			System.out.println(e);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
		dispatcher.forward(request, response);
	}
}
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Employee;
import service.UserRegisterService;

@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserRegistration() {
		super();
	}

	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		
		
		Employee employee = new Employee(request.getParameter("telephone"), request.getParameter("name"),
				request.getParameter("role"), request.getParameter("email"), request.getParameter("pswd"),request.getParameter("username"));

		HashMap<String, Object> employeeDetails = new HashMap<>();
		UserRegisterService registerService = new UserRegisterService();
		PrintWriter out= response.getWriter();
		//testing
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("role"));
		System.out.println(request.getParameter("telephone"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("pswd"));
		System.out.println(request.getParameter("username"));
		
		employeeDetails.put("id", Long.toString(employee.getId()));
		employeeDetails.put("name", employee.getName());
		employeeDetails.put("role", employee.getRole());
		employeeDetails.put("contact_number", employee.getContactNumber());
		employeeDetails.put("email", employee.getEmail());
		employeeDetails.put("password", employee.getPassword());		
		employeeDetails.put("username", employee.getUsername());		
		
		int result=registerService.insert("user_details", employeeDetails);
	     if (result !=0) {
	    	 out.print("Registration successful");
			response.sendRedirect("Login.jsp");
		} else {
		    
		    out.print("Registration Failed!!!\nPlease register again..");
			response.sendRedirect("Register.jsp");
		}

	}

}

package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<String> parameters = new ArrayList<String>();
		HashMap<String, Object> employeeObject = new HashMap<>();
		HashMap<String, String> result = new HashMap<>();
		HttpSession session = request.getSession();

		String id = null;
		String role = null;
		String table_name = "user_details";
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println(username);
		System.out.println(password);

		if (username != null && password != null) {

			employeeObject.put("username", username);
			employeeObject.put("password", password);

			parameters.add("id");
			parameters.add("role");
			LoginService loginService = new LoginService();
			result = loginService.select(table_name, parameters, employeeObject);
			id = result.get("id");
			role = result.get("role");

			if (id != null) {
				session.setAttribute("username", username);
				if (role.equalsIgnoreCase("admin"))
				{
					response.sendRedirect("admin.html");
				} else {
					response.sendRedirect("user.jsp");
					// response.sendRedirect("user.jsp/#name="+username);

					
					// request.setAttribute("name",username);

					// RequestDispatcher rd= request.getRequestDispatcher("user.jsp");
					// rd.forward(request, response);
				}

			} else {
				response.sendRedirect("Login.jsp");
				response.getWriter().append("Served at: ").append(request.getContextPath());
			}

		}

	}

}

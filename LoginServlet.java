package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Employee;
import com.helper.FactoryProvider;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Pull a request from browser and fetch data.
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		// Bring all data from DB
		try {
			// HIBERNATE PART
			Session ses = FactoryProvider.getFactory().openSession();
			Transaction tx = ses.beginTransaction();

			// Retrieve all registered employees except logged in user
			String hql = "FROM Employee e WHERE e.username != :username";
			String excludedUsername = username;

			List<Employee> empList = ses.createQuery(hql, Employee.class).setParameter("username", excludedUsername)
					.list();

			// SERVLET PART
			request.setAttribute("welcome", empList);

			// Display the username who logged in on top
			String hql1 = "SELECT e.name FROM Employee e WHERE e.username = :username";
			String usernameToSearch = username;

			List<String> employeeNames = ses.createQuery(hql1).setParameter("username", usernameToSearch)
					.list(); /*
								 * Since here we did not used <Employee>, there is no need to use Employee.class
								 */

			tx.commit();
			ses.close();

			// for each loop to retrieve data from collection <list>
			for (String name : employeeNames) {
				request.setAttribute("name", name);
			}

			// forward this list to JSP file
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// checking if username is valid or not
		try {
			if (isValidUser(username, password)) {

				response.sendRedirect("welcome.jsp");
			} else {
				request.setAttribute("errorMessage", "Invalid username or password");
				RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
				disp.forward(request, response);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ServletException e) {

			e.printStackTrace();
		}

	}

	// Create a method that will help in checking if a user exist in DB
	private boolean isValidUser(String username, String password) throws SQLException {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya", "root", "root");
				PreparedStatement ps = con.prepareStatement("SELECT * FROM emp WHERE username = ? AND password = ?")) {

			ps.setString(1, username);
			ps.setString(2, password);

			try (ResultSet rs = ps.executeQuery()) {
				return rs.next();
			}
		} catch (SQLException s) {
			s.printStackTrace();
			return false;
		}
	}

}

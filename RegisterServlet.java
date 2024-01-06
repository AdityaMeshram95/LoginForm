package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Employee;
import com.helper.FactoryProvider;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Fetch the coming values from reg.jsp page
		try {

			String name = request.getParameter("name");
			String date = request.getParameter("DOB");
			String gender = request.getParameter("gender");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String username = request.getParameter("Username");
			String password = request.getParameter("Password");

			// Create object of entity class
			Employee e = new Employee(name, date, gender, address, city, state, username, password);

			// Save this data in DATABASE
			Session ses = FactoryProvider.getFactory().openSession(); // method call
			Transaction tx = ses.beginTransaction();
			ses.persist(e);

			tx.commit();
			ses.close();

			// Response in browser that data is saved
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			out.println("<h1>Registered succesfull...</h1>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

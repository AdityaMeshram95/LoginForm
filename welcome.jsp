<%@page import="com.entity.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
</head>
<body>
	<h1 class="bg-dark text-white p-1" style="text-align: center;">Welcome
		page</h1>
	<h2 class="text-right text-danger">
		Welcome,
		<%=request.getAttribute("name")%>
	</h2>
	<hr>
	<div class="card mt-2 p-3">
		<h3 class="card-header bg-success text-white">Below are the list
			of Employees</h3>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">name</th>
					<th scope="col">username</th>
				</tr>
			</thead>
			<tbody>

				<%
				//Retrieve the employee list from the request attribute
				List<Employee> empList = (List<Employee>) request.getAttribute("welcome");

				// check if list is empty
				if (empList != null && !empList.isEmpty()) {

					for (Employee employee : empList) {
						out.println("<tr>");
						// Display employee names
						out.println("<td>" + employee.getName() + "</td>");
						out.println("<td>" + employee.getUsername() + "</td>");
						out.println("</tr>");
					}

				} else {
					out.println("<p>No employees found</p>");
				}
				%>

			</tbody>
		</table>
	</div>
</body>
</html>
# Employee Management System

This is a simple Employee Management System implemented using Java Servlets and Hibernate. The system allows users to register employees and view a list of registered employees.

## Technologies Used

- Java Servlets
- Hibernate
- HTML/CSS

## Project Structure

- **Web Pages:**
  - `index.jsp`: Login page for users.
  - `reg.jsp`: Registration page for new employees.
  - `welcome.jsp`: Displaying a list of registered employees.

- **CSS Files:**
  - `css-file/login.css`: Styles for the login page.
  - `css-file/reg.css`: Styles for the registration page.

- **Servlets:**
  - `LoginServlet.java`: Handles user login and displays the list of employees.
  - `RegisterServlet.java`: Handles employee registration.

- **Entity Class:**
  - `Employee.java`: Represents the Employee entity with fields like name, date of birth, gender, etc.

- **Hibernate Configuration:**
  - `FactoryProvider.java`: Configures the Hibernate Session Factory.

## Database Configuration

- The project uses a MySQL database.
- Database configuration details can be found in the `hibernate.cfg.xml` file.

## How to Run

1. Clone the repository.
2. Configure your MySQL database and update `hibernate.cfg.xml` with your database details.
3. Build and deploy the project to a servlet container (e.g., Apache Tomcat).
4. Access the application in your browser.

## Project Usage

1. Visit the login page (`index.jsp`) to enter your credentials.
2. Click on the "Sign Up" button to register a new employee (`reg.jsp`).
3. The list of registered employees can be viewed on the "Welcome Page" (`welcome.jsp`) after logging in.

Feel free to contribute and improve the system!

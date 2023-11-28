package ru.aston.servlet;



import ru.aston.dao.EmployeeDAO;
import ru.aston.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/employee")
public class EmployeeServlet extends HttpServlet {

    private final EmployeeDAO employeeDAO;

    public EmployeeServlet() {
        this.employeeDAO = new EmployeeDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = employeeDAO.showAllEmployee();
        System.out.println(employees);
        request.setAttribute("employees", employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/index.jsp");
        dispatcher.forward(request, response);
    }
}

package ru.aston.servlet;



import ru.aston.dao.DepartmentDAO;
import ru.aston.model.Department;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/department")
public class DepartmentServlet extends HttpServlet{
    private final DepartmentDAO departmentDAO;

    public DepartmentServlet() {
        this.departmentDAO = new DepartmentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> departments = departmentDAO.showAllDepartment();
        System.out.println(departments);
        request.setAttribute("departments", departments);
        RequestDispatcher dispatcher = request.getRequestDispatcher("department/index.jsp");
        dispatcher.forward(request, response);
    }
}

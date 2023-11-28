package ru.aston.servlet;



import ru.aston.dao.CompanyDAO;
import ru.aston.entity.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/company")
public class CompanyServlet extends HttpServlet{
    private final CompanyDAO companyDAO;

    public CompanyServlet() {
        this.companyDAO = new CompanyDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Company> companies = companyDAO.showAll();
        request.setAttribute("companies", companies);
        request.getRequestDispatcher("company/index.jsp").forward(request, response);

    }
}

package main;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.CustomerDAO;
import model.Customer;

@WebServlet("/addCustomer")
public class AddCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/addCustomer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String registerDateStr = request.getParameter("registerDate");

        try {
            java.sql.Date sqlDate = java.sql.Date.valueOf(registerDateStr);

            Customer c = new Customer();
            c.setFullname(fullname);
            c.setPhone(phone);
            c.setRegisterDate(sqlDate);

            Connection conn = DBConnection.getConnection();
            CustomerDAO dao = new CustomerDAO(conn);

            dao.insertCustomer(c);

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/customers");
    }
}
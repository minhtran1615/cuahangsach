package main;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import model.Customer;

public class CustomerListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Connection conn = DBConnection.getConnection();

            CustomerDAO dao = new CustomerDAO(conn);
            List<Customer> list = dao.getAllCustomers();

            System.out.println("So luong customer lay duoc: " + list.size());

            request.setAttribute("customers", list);

            request.getRequestDispatcher("/WEB-INF/customer-list.jsp").forward(request, response);

            conn.close(); // dong ket noi

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Loi ket noi database!");
        }
    }
}
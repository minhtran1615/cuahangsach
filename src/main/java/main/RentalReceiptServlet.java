package main;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.RentalReceiptDAO;
import model.RentalReceipt;


@WebServlet("/rentalReceipts")
public class RentalReceiptServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            Connection conn = DBConnection.getConnection();
            RentalReceiptDAO dao = new RentalReceiptDAO(conn);

            List<RentalReceipt> list = dao.getAllRentalReceipts();

            req.setAttribute("listRentalReceipts", list);
            req.getRequestDispatcher("/WEB-INF/rentalReceipt.jsp").forward(req, resp);
            
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Loi ket noi database!");
        }
    }
}
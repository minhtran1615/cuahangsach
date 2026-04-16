package main;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RentalReceiptDAO;

@WebServlet("/deleteRentalReceipt")
public class DeleteRentalReceiptServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));

            Connection conn = DBConnection.getConnection(); // lấy kết nối DB
            RentalReceiptDAO dao = new RentalReceiptDAO(conn); // truyền conn vào DAO
            dao.deleteRentalReceipt(id);

            resp.sendRedirect(req.getContextPath() + "/rentalReceipts");

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Lỗi khi xóa phiếu thuê!");
        }
    }
}
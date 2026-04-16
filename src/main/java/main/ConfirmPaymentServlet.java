package main;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.PaymentDAO;

@WebServlet("/confirmPayment")
public class ConfirmPaymentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Connection conn = null;

        try {
            String selectedIds = req.getParameter("selectedIds");

            if (selectedIds == null || selectedIds.trim().isEmpty()) {
                resp.getWriter().println("Không có phiếu thuê nào để thanh toán!");
                return;
            }

            conn = DBConnection.getConnection();
            PaymentDAO dao = new PaymentDAO(conn);

            // cập nhật status = đã trả
            dao.updateStatusPaid(selectedIds);

            // quay về danh sách truyện
            resp.sendRedirect(req.getContextPath() + "/books");

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Lỗi thanh toán: " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
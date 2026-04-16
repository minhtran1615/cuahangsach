package main;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.InvoiceDAO;
import model.Invoice;

@WebServlet("/payRentalReceipts")
public class PayRentalReceiptsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Connection conn = null;

        try {
            String selectedIds = req.getParameter("selectedIds");

            if (selectedIds == null || selectedIds.trim().isEmpty()) {
                resp.getWriter().println("Bạn chưa chọn phiếu thuê nào!");
                return;
            }

            conn = DBConnection.getConnection();
            InvoiceDAO dao = new InvoiceDAO(conn);

            // lấy dữ liệu hóa đơn từ danh sách phiếu thuê đã chọn
            Invoice invoice = dao.getInvoiceByRentalIds(selectedIds);
            
            req.setAttribute("selectedIds", selectedIds);
            req.setAttribute("invoice", invoice);
            req.getRequestDispatcher("/WEB-INF/invoice.jsp").forward(req, resp);

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
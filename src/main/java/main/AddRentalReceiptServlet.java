package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.RentalReceiptDAO;
import model.RentalReceipt;

@WebServlet("/addRentalReceipt")
public class AddRentalReceiptServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/addRentalReceipt.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Connection conn = null;

        try {
            int customerId = Integer.parseInt(req.getParameter("customerId"));
            int staffId = Integer.parseInt(req.getParameter("staffId"));

            Date rentDate = Date.valueOf(req.getParameter("rentDate"));
            Date returnDate = Date.valueOf(req.getParameter("returnDate"));

            double totalMoney = Double.parseDouble(req.getParameter("totalMoney"));

            // lấy danh sách truyện và số lượng từ form
            String[] bookIds = req.getParameterValues("bookId[]");
            String[] quantities = req.getParameterValues("quantity[]");

            if (bookIds == null || quantities == null || bookIds.length == 0) {
                resp.getWriter().println("Lỗi: Bạn chưa nhập truyện thuê!");
                return;
            }

            conn = DBConnection.getConnection();
            conn.setAutoCommit(false); // transaction

            RentalReceiptDAO dao = new RentalReceiptDAO(conn);

            // tạo phiếu thuê
            RentalReceipt receipt = new RentalReceipt();
            receipt.setCustomerId(customerId);
            receipt.setStaffId(staffId);
            receipt.setRentDate(rentDate);
            receipt.setReturnDate(returnDate);
            receipt.setTotalMoney(totalMoney);

            // insert phiếu thuê và lấy rentalId
            int rentalId = dao.insertRentalReceiptReturnId(receipt);

            // insert chi tiết truyện thuê
            for (int i = 0; i < bookIds.length; i++) {
                int bookId = Integer.parseInt(bookIds[i]);
                int quantity = Integer.parseInt(quantities[i]);

                dao.insertRentalDetail(rentalId, bookId, quantity);
            }

            conn.commit(); // lưu thành công

            resp.sendRedirect(req.getContextPath() + "/rentalReceipts");

        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();
            resp.getWriter().println("Lỗi khi thêm phiếu thuê: " + e.getMessage());

        } finally {
            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
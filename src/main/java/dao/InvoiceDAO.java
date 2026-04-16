package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Invoice;
import model.InvoiceItem;

public class InvoiceDAO {

    private Connection conn;

    public InvoiceDAO(Connection conn) {
        this.conn = conn;
    }

    public Invoice getInvoiceByRentalIds(String selectedIds) throws Exception {

        // selectedIds dạng: "1,2,3"
        String sql = "SELECT TOP 1 r.id, r.customer_id, r.staff_id, r.rent_date, r.return_date, r.total_money, " +
                     "c.fullname AS customer_name, u.full_name AS staff_name " +
                     "FROM rentals r " +
                     "JOIN customers c ON r.customer_id = c.id " +
                     "JOIN users u ON r.staff_id = u.id " +
                     "WHERE r.id IN (" + selectedIds + ")";

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        Invoice invoice = new Invoice();

        if (rs.next()) {
            invoice.setInvoiceCode("PT" + rs.getInt("id"));
            invoice.setCreatedDate(new java.util.Date().toString());

            invoice.setCustomerCode("KH" + rs.getInt("customer_id"));
            invoice.setCustomerName(rs.getString("customer_name"));

            invoice.setStaffCode("NV" + rs.getInt("staff_id"));
            invoice.setStaffName(rs.getString("staff_name"));

            invoice.setRentDate(rs.getDate("rent_date").toString());
            invoice.setReturnDate(rs.getDate("return_date") == null ? "" : rs.getDate("return_date").toString());
        }

        rs.close();
        ps.close();

        // lấy danh sách truyện thuê của tất cả phiếu
        String sqlItems =
                "SELECT b.id AS book_id, b.title, SUM(rd.quantity) AS total_quantity, b.rent_price_per_day " +
                "FROM rental_details rd " +
                "JOIN books b ON rd.book_id = b.id " +
                "WHERE rd.rental_id IN (" + selectedIds + ") " +
                "GROUP BY b.id, b.title, b.rent_price_per_day";

        PreparedStatement ps2 = conn.prepareStatement(sqlItems);
        ResultSet rs2 = ps2.executeQuery();

        List<InvoiceItem> items = new ArrayList<>();
        double totalMoney = 0;

        while (rs2.next()) {
            InvoiceItem item = new InvoiceItem();
            item.setBookId(rs2.getInt("book_id"));
            item.setBookTitle(rs2.getString("title"));
            item.setQuantity(rs2.getInt("total_quantity"));
            item.setPricePerDay(rs2.getDouble("rent_price_per_day"));

            double money = item.getQuantity() * item.getPricePerDay();
            item.setMoney(money);

            totalMoney += money;
            items.add(item);
        }

        rs2.close();
        ps2.close();

        invoice.setItems(items);
        invoice.setTotalMoney(totalMoney);

        return invoice;
    }
}
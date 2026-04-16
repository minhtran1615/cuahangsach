package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PaymentDAO {

    private Connection conn;

    public PaymentDAO(Connection conn) {
        this.conn = conn;
    }

    public void updateStatusPaid(String selectedIds) throws Exception {

        // selectedIds dạng: 1,2,3
        String sql = "UPDATE rentals SET status = N'đã trả' WHERE id IN (" + selectedIds + ")";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.executeUpdate();
        ps.close();
    }
}
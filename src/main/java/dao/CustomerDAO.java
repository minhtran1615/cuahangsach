package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Customer;

public class CustomerDAO {

    private Connection conn;

    public CustomerDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Customer> getAllCustomers() {
        List<Customer> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM customers";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Customer c = new Customer();

                // database của bạn dùng id
                c.setCustomerId(rs.getInt("id"));

                c.setFullname(rs.getString("fullname"));
                c.setPhone(rs.getString("phone"));

                // database của bạn dùng registerDate
                c.setRegisterDate(rs.getDate("registerDate"));

                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
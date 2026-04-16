package model;

import java.sql.Date;

public class RentalReceipt {
    private int rentalId;
    private int customerId;
    private int staffId;
    private Date rentDate;
    private Date returnDate;
    private double totalMoney;

    // Thêm thuộc tính lưu thông tin truyện thuê (mã truyện + số lượng)
    private String bookInfo;

    public RentalReceipt() {}

    public RentalReceipt(int rentalId, int customerId, int staffId, Date rentDate, Date returnDate, double totalMoney) {
        this.rentalId = rentalId;
        this.customerId = customerId;
        this.staffId = staffId;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.totalMoney = totalMoney;
    }

    // Constructor có thêm bookInfo
    public RentalReceipt(int rentalId, int customerId, int staffId, Date rentDate, Date returnDate, double totalMoney, String bookInfo) {
        this.rentalId = rentalId;
        this.customerId = customerId;
        this.staffId = staffId;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.totalMoney = totalMoney;
        this.bookInfo = bookInfo;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    // Getter Setter cho bookInfo
    public String getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(String bookInfo) {
        this.bookInfo = bookInfo;
    }
}
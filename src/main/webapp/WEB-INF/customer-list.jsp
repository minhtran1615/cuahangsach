<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Customer" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách khách hàng</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f4f4;
        padding: 30px;
    }

    h2 {
        text-align: center;
        color: #333;
    }

    .top-bar {
        width: 90%;
        margin: auto;
        display: flex;
        justify-content: space-between;
        margin-bottom: 20px;
    }

    .top-bar a {
        text-decoration: none;
        background: #007bff;
        color: white;
        padding: 10px 15px;
        border-radius: 6px;
        font-weight: bold;
    }

    .top-bar a:hover {
        background: #0056b3;
    }

    .info {
        width: 90%;
        margin: auto;
        margin-bottom: 10px;
        font-weight: bold;
        color: #333;
    }

    table {
        width: 90%;
        margin: auto;
        border-collapse: collapse;
        background: white;
        box-shadow: 0px 0px 10px rgba(0,0,0,0.2);
    }

    th, td {
        border: 1px solid #ccc;
        padding: 12px;
        text-align: center;
    }

    th {
        background: #28a745;
        color: white;
    }

    tr:hover {
        background: #f1f1f1;
    }
</style>

</head>
<body>

<h2>👤 DANH SÁCH KHÁCH HÀNG</h2>

<div class="top-bar">
    <a href="<%=request.getContextPath()%>/books">⬅ Quay lại danh sách truyện</a>
</div>

<%
    List<Customer> list = (List<Customer>) request.getAttribute("customers");
%>

<div class="info">
    Số lượng khách hàng: <%= (list == null ? 0 : list.size()) %>
</div>

<table>
    <tr>
        <th>Mã khách hàng</th>
        <th>Họ tên</th>
        <th>Số điện thoại</th>
        <th>Ngày đăng kí</th>
    </tr>

<%
    if(list != null) {
        for(Customer c : list) {
%>
    <tr>
        <td><%=c.getCustomerId()%></td>
        <td><%=c.getFullname()%></td>
        <td><%=c.getPhone()%></td>
        <td><%=c.getRegisterDate()%></td>
    </tr>
<%
        }
    }
%>

</table>

</body>
</html>
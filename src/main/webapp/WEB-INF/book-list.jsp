<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Book" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách truyện</title>

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
        background: #28a745;
        color: white;
        padding: 10px 15px;
        border-radius: 6px;
        font-weight: bold;
    }

    .top-bar a:hover {
        background: #218838;
    }

    .search-box input {
        padding: 8px;
        width: 200px;
        border-radius: 5px;
        border: 1px solid #ccc;
    }

    .search-box button {
        padding: 8px 12px;
        border: none;
        background: #007bff;
        color: white;
        border-radius: 5px;
        cursor: pointer;
    }

    .search-box button:hover {
        background: #0056b3;
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
        background: #007bff;
        color: white;
    }

    tr:hover {
        background: #f1f1f1;
    }

    .action a {
        text-decoration: none;
        padding: 6px 10px;
        border-radius: 5px;
        margin: 0 3px;
        font-weight: bold;
    }

    .edit {
        background: orange;
        color: white;
    }

    .delete {
        background: red;
        color: white;
    }

    .edit:hover {
        background: darkorange;
    }

    .delete:hover {
        background: darkred;
    }
</style>

</head>
<body>

<h2>📚 DANH SÁCH TRUYỆN TRONG THƯ VIỆN</h2>

<div class="top-bar">
    <a href="<%=request.getContextPath()%>/addBook">➕ Thêm truyện mới</a>

    <form class="search-box" action="<%=request.getContextPath()%>/searchBook" method="get">
        <input type="text" name="keyword" placeholder="Nhập tên truyện...">
        <button type="submit">Tìm</button>
    </form>
</div>

<table>
    <tr>
        <th>ID</th>
        <th>Tên truyện</th>
        <th>Tác giả</th>
        <th>Thể loại</th>
        <th>Số lượng</th>
        <th>Hành động</th>
    </tr>

<%
    List<Book> list = (List<Book>) request.getAttribute("books");

    if(list != null) {
        for(Book b : list) {
%>

    <tr>
        <td><%=b.getId()%></td>
        <td><%=b.getTitle()%></td>
        <td><%=b.getAuthor()%></td>
        <td><%=b.getCategory()%></td>
        <td><%=b.getQuantity()%></td>

        <td class="action">
            <a class="edit" href="<%=request.getContextPath()%>/editBook?id=<%=b.getId()%>">Sửa</a>

            <a class="delete"
               href="<%=request.getContextPath()%>/deleteBook?id=<%=b.getId()%>"
               onclick="return confirm('Bạn có chắc muốn xóa truyện này không?')">
               Xóa
            </a>
        </td>
    </tr>

<%
        }
    }
%>

</table>

</body>
</html>
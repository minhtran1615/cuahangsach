<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="model.Book" %>

<%
    Book b = (Book) request.getAttribute("book");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sửa truyện</title>
</head>
<body>

<h2>✏️ SỬA TRUYỆN</h2>

<form action="<%=request.getContextPath()%>/editBook" method="post">

    <input type="hidden" name="id" value="<%=b.getId()%>">

    Tên truyện: <input type="text" name="title" value="<%=b.getTitle()%>" required><br><br>
    Tác giả: <input type="text" name="author" value="<%=b.getAuthor()%>"><br><br>
    Thể loại: <input type="text" name="category" value="<%=b.getCategory()%>"><br><br>
    Số lượng: <input type="number" name="quantity" value="<%=b.getQuantity()%>" required><br><br>

    <button type="submit">Cập nhật</button>
</form>

<br>
<a href="<%=request.getContextPath()%>/books">⬅ Quay lại danh sách</a>

</body>
</html>
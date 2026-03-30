<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm truyện</title>
</head>
<body>

<h2>➕ THÊM TRUYỆN MỚI</h2>

<form action="<%=request.getContextPath()%>/addBook" method="post">
    Tên truyện: <input type="text" name="title" required><br><br>
    Tác giả: <input type="text" name="author"><br><br>
    Thể loại: <input type="text" name="category"><br><br>
    Số lượng: <input type="number" name="quantity" required><br><br>

    <button type="submit">Thêm</button>
</form>

<br>
<a href="<%=request.getContextPath()%>/books">⬅ Quay lại danh sách</a>

</body>
</html>
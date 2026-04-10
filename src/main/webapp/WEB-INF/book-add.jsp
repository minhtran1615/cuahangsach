<!-- <%@ page contentType="text/html; charset=UTF-8" %> -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm truyện mới</title>

<style>
    body {
        margin: 0;
        font-family: Arial, sans-serif;
        background: linear-gradient(to right, #1e3c72, #2a5298);
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .container {
        width: 500px;
        background: white;
        padding: 30px;
        border-radius: 15px;
        box-shadow: 0px 10px 25px rgba(0,0,0,0.3);
        animation: fadeIn 0.8s ease-in-out;
    }

    h2 {
        text-align: center;
        margin-bottom: 25px;
        color: #1e3c72;
        font-size: 26px;
    }

    label {
        font-weight: bold;
        display: block;
        margin: 12px 0 6px;
        color: #333;
    }

    input {
        width: 95%;
        padding: 12px;
        border-radius: 8px;
        border: 1px solid #ccc;
        outline: none;
        font-size: 14px;
        transition: 0.3s;
    }

    input:focus {
        border-color: #2a5298;
        box-shadow: 0 0 6px rgba(42,82,152,0.6);
    }

    .btn {
        width: 100%;
        padding: 12px;
        margin-top: 20px;
        border: none;
        border-radius: 8px;
        background: linear-gradient(to right, #28a745, #218838);
        color: white;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        transition: 0.3s;
    }

    .btn:hover {
        transform: scale(1.02);
        opacity: 0.95;
    }

    .back {
        display: block;
        text-align: center;
        margin-top: 20px;
        text-decoration: none;
        font-weight: bold;
        color: #2a5298;
        transition: 0.3s;
    }

    .back:hover {
        color: #1e3c72;
        text-decoration: underline;
    }

    @keyframes fadeIn {
        from {
            opacity: 0;
            transform: translateY(20px);
        }
        to {
            opacity: 1;
            transform: translateY(0);
        }
    }

    .icon {
        font-size: 35px;
        text-align: center;
        display: block;
        margin-bottom: 10px;
    }
</style>

</head>
<body>

<div class="container">
    <span class="icon">📚</span>
    <h2>THÊM TRUYỆN MỚI</h2>

    <form action="<%=request.getContextPath()%>/addBook" method="post">

        <label>Tên truyện</label>
        <input type="text" name="title" placeholder="Nhập tên truyện..." required>

        <label>Tác giả</label>
        <input type="text" name="author" placeholder="Nhập tên tác giả...">

        <label>Thể loại</label>
        <input type="text" name="category" placeholder="Nhập thể loại truyện...">

        <label>Số lượng</label>
        <input type="number" name="quantity" placeholder="Nhập số lượng..." required min="0">

        <button type="submit" class="btn">➕ Thêm truyện</button>
    </form>

    <a class="back" href="<%=request.getContextPath()%>/books">⬅ Quay lại danh sách</a>
</div>

</body>
</html>
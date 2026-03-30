<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>

<body>
<div class="container">
    <h1>Đăng nhập</h1>

    <form action="<%=request.getContextPath()%>/login" method="post">
        <label>Tài khoản:</label>
        <input type="text" name="username" required>

        <br><br>

        <label>Mật khẩu:</label>
        <input type="password" name="password" required>

        <br><br>

        <button type="submit">Đăng nhập</button>
    </form>
</div>
</body>
</html>
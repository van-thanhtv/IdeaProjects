<%--
  Created by IntelliJ IDEA.
  User: thanhkali
  Date: 3/9/22
  Time: 12:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PH15016</title>
</head>
<body>
<form action="DangKiServlet" method="post">
    Tên đăng nhập : <input type="text" name="username"><br>
    Mật khẩu <input type="password" name="password"><br>
    Giới tính
    <input type="radio" name="gt1" value="true"> Nam
    <input type="radio" name="gt1" value="false"> Nữ <br>
    <input type="checkbox" name="married">Đã có gia đình ? <br>
    Quốc tịch : <select name="country">
    <option value="VN">Việt Nam</option>
    <option value="US">United States</option>
                </select> <br>
    sở thích :
    <input type="checkbox" name="hobbeies" value="R">Đọc sánh
    <input type="checkbox" name="hobbeies" value="T">Du lịch
    <input type="checkbox" name="hobbeies" value="M">Âm nhạc
    <input type="checkbox" name="hobbeies" value="O">Khác <br>
    Ghi chú : <textarea name="notes" cols="30" rows="3"></textarea>
    <hr>
    <button type="submit">Đăng kí</button>
</form>
</body>
</html>

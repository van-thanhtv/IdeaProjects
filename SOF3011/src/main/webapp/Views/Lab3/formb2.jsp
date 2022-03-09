<%--
  Created by IntelliJ IDEA.
  User: thanhkali
  Date: 3/9/22
  Time: 9:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="StaffServlet" method="post">
    Họ và tên: <input name="fullname"><br>
    Ngày sinh: <input name="birthday"><br>
    Quốc tịch:
    <select name="country">
        <option value="VN">Việt Nam</option>
        <option value="US">United States</option>
    </select><br>
    Giới tính:
    <input name="gender" type="radio" value="true">Nam
    <input name="gender" type="radio" value="false">Nữ<br>
    TT hôn nhân:
    <input name="married" type="checkbox">Đã có gia đình?<br>
    Sở thích:
    <input name="hobbies" type="checkbox" value="R">Đọc sách
    <input name="hobbies" type="checkbox" value="T">Du lịch
    <input name="hobbies" type="checkbox" value="M">Âm nhạc
    <input name="hobbies" type="checkbox" value="O">Khác<br>
    Ghi chú: <textarea name="notes" rows="3" cols="30"></textarea>
    <hr>
    <button>Thêm mới</button>
</form>
</body>
</html>

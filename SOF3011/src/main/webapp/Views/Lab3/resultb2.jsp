<%--
  Created by IntelliJ IDEA.
  User: thanhkali
  Date: 3/9/22
  Time: 9:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <li>Họ và tên: <b>${bean.fullname}</b></li>
    <li>Ngày sinh: <b>${bean.birthday}</b></li>
    <li>Giới tính: <b>${bean.gender}</b></li>
    <li>Quốc tịch: <b>${bean.country}</b></li>
    <li>TT hôn nhân: <b>${bean.married}</b></li>
    <li>Sở thích: <b>${bean.hobbies}</b></li>
    <li>Ghi chú: <b>${bean.notes}</b></li>
</ul>
</body>
</html>

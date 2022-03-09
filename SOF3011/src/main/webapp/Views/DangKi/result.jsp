<%--
  Created by IntelliJ IDEA.
  User: thanhkali
  Date: 3/9/22
  Time: 12:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ph15016</title>
</head>
<body>
<ul>
    <li>Tên Đăng nhập :<b>${param.username}</b></li>
    <li>Mật khẩu :<b>${param.password}</b></li>
    <li>Giới tính :<b>${param.gt1}</b></li>
    <li>Tình trạng hôn nhân :<b>${param.married}</b></li>
    <li>Quốc tịch :<b>${param.country}</b></li>
    <li>Sở thích :<b>${paramValues.hobbeies}</b></li>
    <li>Ghi chú :<b>${param.notes}</b></li>
</ul>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: thanhkali
  Date: 3/9/22
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PH15016</title>
</head>
<body>
<h2>1. Hình: ${img.name}</h2>
<img src="files/${img.name}" height="200" width="200"/>
<h2>2. Tài liệu: ${doc.name}</h2>
<a href="files/${doc.name}">Tải về</a>
</body>
</html>

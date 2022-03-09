<%--
  Created by IntelliJ IDEA.
  User: thanhkali
  Date: 3/9/22
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="UploadServlet" method="post" enctype="multipart/form-data">
    Hình ảnh : <input type="file" name="poto"><br>
    Tài liệu : <input type="file" name="doc_file"><br>
    <hr>
    <button type="submit">Upload</button>
</form>
</body>
</html>

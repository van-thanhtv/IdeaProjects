<%--
  Created by IntelliJ IDEA.
  User: thanhkali
  Date: 3/8/22
  Time: 7:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>  
<head>
    <title>PH15016</title>
    <link rel="stylesheet" href="/src/main/webapp/Views/css/bootstrap.rtl.min.css">
</head>
<body>
    <div class="container">
      <form method="post" action="ChuNhatServlet">
        <h1>Thông tin hình chữ nhật</h1>
        <h2>Chiều rộng :</h2>
        <input name="dai" class="form-control form-control-lg" type="text" aria-label=".form-control-lg example">
        <h2>Chiều dài :</h2>
        <input name="rong" class="form-control form-control-lg" type="text" aria-label=".form-control-lg example">
        <button type="submit" class="btn btn-info">Tính</button>
      </form>
    </div>
    <script src="/src/main/webapp/Views/js/bootstrap.min.js"></script>
    <script src="/src/main/webapp/Views/js/jquery.min.js"></script>
    <script src="/src/main/webapp/Views/js/popper.min.js"></script>
</body>
</html>

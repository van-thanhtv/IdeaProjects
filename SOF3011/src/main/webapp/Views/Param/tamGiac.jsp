<%--
  Created by IntelliJ IDEA.
  User: thanhkali
  Date: 3/8/22
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PH15016</title>
</head>
<body>
  <div>
    <h1>Tam giác</h1>
      <form action="TamGiacServlet" method="post">
        <input name="a" type="text" placeholder="Cạnh a ?">
        <input name="b" type="text" placeholder="Cạnh b ?">
        <input name="c" type="text" placeholder="Cạnh c ?">
        <hr>
        <div style="margin: 5pt;">
          <button formaction="/SOF3011/dienTich">Tính diện tích</button>
          <button formaction="/SOF3011/chuVi">Tính chu vi</button>
        </div>
      </form>
      <h3>${message}</h3>
  </div>
</body>
</html>

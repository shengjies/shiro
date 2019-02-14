<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/1/25
  Time: 下午4:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    ${errorMsg}
    <form method="post" action="/toLogin">
        <label>
            用户名:<input name="username">
        </label>
        <br/>
        <label>
            密 码:<input type="password" name="password">
        </label>
        <br/>
        <input type="submit" value="登录">
    </form>
</body>
</html>

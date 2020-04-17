<%--
  Created by IntelliJ IDEA.
  User: a1103
  Date: 2020/4/14
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>查询所有的账户</h1>
    <c:forEach items="${list}" var="account">
       ${account.user} ${account.passwd}<br>
    </c:forEach>
</body>
</html>

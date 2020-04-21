<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h1>用户注册</h1>
<form action="api/account/save" method="post">
    姓名：<input type="text" name="user" /><br/>
    密码：<input type="text" name="passwd" /><br/>
    <input type="submit" value="保存"/><br/>
</form>
<a href="api/account/user">测试SpringMVC查询</a>
</body>
</html>
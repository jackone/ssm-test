<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/5
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加页面</title>
</head>
<body>
<form method="post" action="/comment/${param.newsid}/add">
    <h1>添加评论</h1>
    评论内容：<textarea name="content"></textarea></br>
    评论人：<input name="author"></br>
<input type="submit" value="提交">
</form>

</body>
</html>

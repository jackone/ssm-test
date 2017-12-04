<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/5
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<html>
<link type="text/css" rel="stylesheet" href="/statics/js/mybootstrap.css">
<head>
    <title>Title</title>

</head>
<body>
<h1>评论列表</h1><span><a href="/new/all" >点击返回新闻列表</a> </span>

<div >
    <table >
        <thead>
        <tr>
            <th>评论编号</th>
            <th>评论内容</th>
            <th>评论人</th>
            <th>评论时间</th>

        </tr>
        </thead>

        <tbody >
        <c:forEach items="${commentList}" var="comment">
            <tr><td>${comment.id}</td>
                <td>${comment.content}</td>
                <td >${comment.author}</td>
                <td >
                    <fmt:formatDate value="${comment.createDate}" pattern="yyyy-MM-dd hh:mm"></fmt:formatDate>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>

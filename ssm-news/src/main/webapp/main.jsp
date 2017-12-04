<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/3
  Time: 21:00
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
<form action="mohu" method="post">
    新闻标题：<input name="title">
    <button>查询</button>
</form>
<h1>新闻列表</h1>

<div >
    <table >
        <thead>
        <tr>
            <th>新闻编号</th>
            <th>新闻标题</th>
            <th>新闻摘要</th>
            <th>创建时间</th>
            <th>作者</th>
            <th>操作</th>
        </tr>
        </thead>

        <tbody >
        <c:forEach items="${details}" var="detail">
            <tr><td>${detail.id}</td>
                <td>${detail.title}</td>
                <td >${detail.summary}</td>
                <td >
                    <fmt:formatDate value="${detail.createdate}" pattern="yyyy-MM-dd hh:mm"></fmt:formatDate>
                </td>
                <td >
                    <span >${detail.author}</span>
                </td>
                <td  >
                    <a href="/comment/${detail.id}/select">查看评论</a>
                    <a  href="/addComment.jsp?newsid=${detail.id}">评论</a>
                    <a href="/new/${detail.id}/delNews" onclick="if(confirm('确定删除?')==false)return false;">删除</a>
                </td>

            </tr>

        </c:forEach>
        </tbody>
    </table>

    <table>
        <tr >
            <td ><span style="color: crimson" >${param.msg}</span></td>
        </tr>
    </table>
</div>
</body>
</html>




<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" width="30%">
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>金额</td>
    </tr>
    <c:forEach items="${accountList}" var="account" varStatus="vs">
        <tr>
            <td>${vs.count}</td>
            <td>${account.name}</td>
            <td>${account.money}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

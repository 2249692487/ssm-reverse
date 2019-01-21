<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${all}" var="Account">
        ${Account.name} ============== ${Account.money}
        <hr/>
    </c:forEach>
</body>
</html>

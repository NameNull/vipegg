<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./common/includes.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@include file="./common/meta.jsp" %>
    <title>小程序练习</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
</head>
<body>
    <h1>小程序demo</h1>
    <ul>
        <c:forEach items="${list}" var="item">
            <li>${item.name}:${item.description}:${item.statusEnum.name}</li>
        </c:forEach>
    </ul>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đếm ký tự</title>
</head>
<body>
    <h2>Ứng dụng đếm số ký tự</h2>
    <form action="count" method="post">
        Nhập chuỗi: <input type="text" name="inputString" value="${value != null ? value : ''}"/>
        <input type="submit" value="Đếm"/>
    </form>

    <c:if test="${not empty count}">
        <p>Chuỗi bạn nhập: ${value}</p>
        <p>Số ký tự: ${count}</p>
    </c:if>
</body>
</html>

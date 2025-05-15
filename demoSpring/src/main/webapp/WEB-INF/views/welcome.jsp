<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Trang chào mừng</title>
</head>
<body>
    <h2><c:out value="${welcome.message}" /></h2>
    <h3>Hoàng Phú Bình</h3>
    <p>Thời gian hiện tại:  
    <%
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentTime = sdf.format(new java.util.Date());
        out.print(currentTime);
    %>
    </p>
</body>
</html>
s
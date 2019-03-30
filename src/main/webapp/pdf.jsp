<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<iframe src="<c:url value="/pdf/web/viewer.html" />?file=/monitor/displayPDF${param.id }.do"
        width="100%" height="100%"></iframe>

</body>
</html>
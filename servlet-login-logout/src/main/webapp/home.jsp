<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Home</title>
</head>
<body>

    <p>
        Welcome,
        <%=session.getAttribute("sessuser")%>
        ! You have successfully logged in. Thank you. &nbsp; &nbsp;<a
            href="<%=request.getContextPath()%>/logout">Logout</a>
    </p>

</body>
</html>
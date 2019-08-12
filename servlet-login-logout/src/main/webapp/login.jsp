<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login</title>
</head>
<body>
    <%
	    Cookie[] cookies=request.getCookies();
	    String userName = "", password = "",rememberVal="";
	    if (cookies != null) {
	         for (Cookie cookie : cookies) {
	           if(cookie.getName().equals("cookuser")) {
	             userName = cookie.getValue();
	           }
	           if(cookie.getName().equals("cookpass")){
	             password = cookie.getValue();
	           }
	           if(cookie.getName().equals("cookrem")){
	             rememberVal = cookie.getValue();
	           }
	        }
	    }
	%>
    <fieldset style="width: 600px; margin: auto;">
        <legend>Login</legend>
        <div>
            <%=request.getAttribute("msg") != null ? request.getAttribute("msg") : ""%>
            <form name="loginForm" method="post"
                action="<%=request.getContextPath()%>/login">
                <p>
                    <label>Username</label> <input type="text" name="username"
                        autocomplete="off" value="<%=userName%>" />
                </p>
                <p>
                    <label>Password</label> <input type="password" name="password"
                        autocomplete="off" value="<%=password%>" />
                </p>
                <p>
                    <label>Remember</label> <input type="checkbox" name="remember"
                        value="1"
                        <%= "1".equals(rememberVal.trim()) ? "checked=\"checked\"" : "" %> />
                </p>
                <p>
                    <input type="submit" name="login" value="Login" />
                </p>
            </form>
        </div>
    </fieldset>
</body>
</body>
</html>
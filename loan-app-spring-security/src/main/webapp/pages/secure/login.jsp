<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="resources/css/header.css">
<title>Login Page</title> </head>
<body>
<form name="actionForm" action="/loan-app/j_spring_security_check" method ="POST">
<table>
<tr>
<td>
</td>
</tr>
<tr><td>Enter your Username: </td><td><input id="j_username" name="j_username" type="text"/></td></tr>
<tr><td>Enter your Password: </td><td><input id="j_password" name="j_password" type="password"/></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="submit"> </td></tr>

</table>
<P>Don't have an account? Create one </P>
<a href = 'Register.jsp'>Register/Create an account</a>
</form>

</body>
</html>
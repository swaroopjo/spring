<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="Stylesheet" href="/loan-app/resources/css/main.css" type="text/css" />
<title>Home</title>
</head>
<body>
    <div class="header row" style="border:solid">
       <c:import url="/pages/header.jsp"/>
    </div>
 
    <div class="lNav row scroll-y" style="border:solid;">
   		<c:import url="/pages/navigation.jsp"/>
    </div>
    
    <div class="body row scroll-y" style="border:solid">
    	<div style="margin:50px;">
    		This is just a splash page
    	</div>
        
    </div>
 
    <div class="footer row" style="border:solid;text-align:center;margin-top:10px;">
        <c:import url="/pages/footer.jsp"/>
    </div>
</body>
</html>
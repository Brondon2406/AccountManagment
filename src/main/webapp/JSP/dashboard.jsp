<%@page import="model.entities.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <% 
 	Users user = (Users) request.getAttribute("User");
 	String completName = user.getName() + " " + user.getSurname(); 
 	String appTitle = (String) request.getAttribute("appTitle");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> <%=appTitle %> </title>
</head>
<body>
	<h3> Welcome Mr/Mrs <%=completName %> </h3>
</body>
</html>
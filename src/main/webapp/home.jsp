<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String appTitle = (String) request.getAttribute("appTitle");
String Url = request.getContextPath() + "/Home";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=appTitle %></title>
</head>
<body>
	<div class="">
		<h2 class=""> Welcome to <%=appTitle %> </h2>
		<form action="<%=Url%>" method="post" class="form">
			<div>
				<label for="login"> Login :  </label>
				<input type= text" name="login" value="" placeholder="Enter your login"/>
			</div>
			<div>
				<label for="password"> Password :  </label>
				<input type="password" name="pwd" value="" placeholder="Enter your password"/>
			</div>
			<div>
				<input type="submit" name="connect" value="Connect"/>
			</div>
		</form>
	</div>
</body>
</html>
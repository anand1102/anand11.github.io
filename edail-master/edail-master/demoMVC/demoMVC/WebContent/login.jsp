<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String str=(String)request.getAttribute("msg");
%>
<h4>welcome <%= str %></h4>
<form method="post" action="LoginController">
<h5>usernmae</h5><input type="text" name="username">
<h5>password</h5><input type="password" name="password">
<input type="submit" value="Login">
</form>
</body>
</html>
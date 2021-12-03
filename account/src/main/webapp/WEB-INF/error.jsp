<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="GBK"%>
<!DOCTYPE html>
<html>
	<head>
		<title>出错页面</title>
	</head>
	<body>
    		出错了，${message}
    		<%
    			response.setHeader("refresh", "2; url=../login.html");
    		%>
	</body>
</html>
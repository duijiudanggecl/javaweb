<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="GBK"%>
<!DOCTYPE html>
<html>
	<head>
		<title>����ҳ��</title>
	</head>
	<body>
    		�����ˣ�${message}
    		<%
    			response.setHeader("refresh", "2; url=../login.html");
    		%>
	</body>
</html>
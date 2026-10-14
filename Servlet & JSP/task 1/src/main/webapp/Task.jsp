<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% int id = 5; String name = "Ziad"; %>

<%!
	public String idAndName(int id, String name){
		return "id = "+ id +", name = " + name;  
	
	}  
%>

<%= idAndName(id, name) %>


</body>
</html>
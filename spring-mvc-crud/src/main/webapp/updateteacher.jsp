<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="updateteacher?tid=${update.getId()}" modelAttribute="update" >
		Id : <form:input path="id"/><br><br>
		Name: <form:input path="name"/><br><br>
		Age : <form:input path="age"/><br><br>
		<form:button>submit</form:button>
	</form:form>
</body>
</html>
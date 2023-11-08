<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

	<style type="text/css">
		th{
		background-color: yellow;
		}
	
	</style>
</head>
<body>
	<table border="2px" style="border-collapse: collapse;">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Age</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="teacher" items="${list}">
		<tr>
			<td>${teacher.getId()}</td>
			<td>${teacher.getName()}</td>
			<td>${teacher.getAge()}</td>
			<td><a href="getbyid?id=${teacher.getId()}" style="background-color: blue; color: black;">Edit</a></td>
			<td><a href="deleteteacher?id=${teacher.getId()}" style="background-color: red;color: black;">Delete</a></td>
			
		</tr>
		</c:forEach>
	</table> <br>
	<a href="home">Home</a>

</body>
</html>
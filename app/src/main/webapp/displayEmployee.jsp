<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="portfolio-items-wrapper1">
		<table>
				<tr>
					<td>Employee Details are: </td>
				</tr>
				<tr>
					<td>Employee Id</td>
					<td> ${empl.id}</td>
				</tr>
				<tr>
					<td>Employee Name</td>
					<td> ${empl.name}</td>
				</tr>
				<tr>
					<td>Employee Email</td>
					<td> ${empl.email}</td>
				</tr>
			
		</table>
	</div>
</div>
</body>
</html>
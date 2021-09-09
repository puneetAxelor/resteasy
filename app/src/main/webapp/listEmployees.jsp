<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


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
				<td>Id</td>
				<td>Name</td>
				<td>Email</td>
				<td>Laptop Id</td>
				<td>Laptop Name</td>
			</tr>
			<c:forEach items = "${lis}" var = "item">
				<tr>
					<td> ${item.id}</td>
					<td> ${item.name}</td>
					<td> ${item.email}</td>
					
					<c:forEach items = "${item.getLaptop()}" var = "ite">
					<td> ${ite.getLid()}</td>
					<td> ${ite.getLname()}</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>
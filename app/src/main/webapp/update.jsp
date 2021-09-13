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

<h2>Enter Employee Details</h2>

<form method="post" action="http://localhost:8080/app/app/hello/upt">
	<div class="portfolio-items-wrapper1">
		<div class="portfolio-item-wrapper">
			<div class="img-text-wrapper">
			
				<table>
					<tr>
						<td>Id</td>
						<td><input type="text" name="eid" value="${empl.id }" /></td>
					</tr>
					<tr>
						<td>Name</td>
						<td><input type="text" name="ename" value="${empl.name }" /></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name="eemail" value="${empl.email }" /></td>
					</tr>
					<c:forEach items = "${empl.getLaptop()}" var = "ite">
					
					<tr>
						<td>Laptop Id</td>
						<td><input type="text" name="lid" value="${ite.getLid()}" /></td>
					</tr>
					<tr>
						<td>Laptop Name</td>
						<td><input type="text" name="lname" value="${ite.getLname()}"  /></td>
					</tr>
					</c:forEach>
					<tr>
						<td><input type="submit"/></td>
					</tr>
				</table>
			
			</div>
		</div>
	</div>
</form>

</body>
</html>
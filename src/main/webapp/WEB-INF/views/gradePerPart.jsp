<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/main.css">
<title>Grade Per Part</title>
</head>
<body>
	<table>
		<tr>
			<c:forEach var="gradePerPart" items="${gradePerParts }">
				<th><c:out value="${gradePerPart.part }"></c:out></th>				
			</c:forEach>
			
			<th>총학점</th>
		</tr>

		<tr>
			<c:forEach var="gradePerPart" items="${gradePerParts }">
				<td><c:out value="${gradePerPart.grade }"></c:out></td>
			</c:forEach>
			
			<td><c:out value="${sumGrade}"></c:out></td>
		</tr>

	</table>
	<p><a href="${pageContext.request.contextPath }"> return to home. </a></p>
</body>
</html>
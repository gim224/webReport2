<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/main.css">
<title>2017-1 Register Entry</title>
</head>
<body>
	<table>
	<tr><th colspan="4">2017-1 entries</th> </tr>
		<tr>
			<th>교과코드</th>
			<th>교과목명</th>
			<th>구분</th>
			<th>학점</th>
		</tr>
		<c:forEach var="subject" items="${subjects }">
			<tr>
				<td><c:out value="${subject.id }"></c:out></td>
				<td><c:out value="${subject.name }"></c:out></td>
				<td><c:out value="${subject.part }"></c:out></td>
				<td><c:out value="${subject.grade }"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	
	<p><a href="${pageContext.request.contextPath }"> return to home. </a></p>
</body>
</html>
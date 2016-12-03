<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/main.css">
<title>Grade Per Year and Semester</title>
</head>
<body>
	<table>
		<tr>
			<th>년도</th>
			<th>학기</th>
			<th>이수 학점</th>
			<th>상세보기</th>
		</tr>
		<c:forEach var="gradePerYearSemester"
			items="${gradePerYearSemesters }">
			<tr>
				<td><c:out value="${gradePerYearSemester.year }"></c:out></td>
				<td><c:out value="${gradePerYearSemester.semester }"></c:out></td>
				<td><c:out value="${gradePerYearSemester.grade }"></c:out></td>
				<td><a
					href="${pageContext.request.contextPath}/gradeperyearsemester/detail?year=${gradePerYearSemester.year }&semester=${gradePerYearSemester.semester }">
						detail</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
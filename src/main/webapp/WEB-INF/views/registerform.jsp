<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/main.css">

<title>2017 1st-semester register</title>
</head>
<body>
	<sf:form action="${pageContext.request.contextPath }/docreate" method="POST" modelAttribute="subject">
		<table>
			<tr>
				<td>교과코드</td>
				<td><sf:input type="text" name="id" path="id"/><br/>
					<sf:errors path="id" class="error"></sf:errors>
				</td>
			</tr>
			<tr>
				<td>교과목명</td>				
				<td><sf:input type="text" name="name" path="name"/><br/>
				<sf:errors path="name" class="error"></sf:errors>
				</td>
			</tr>
			<tr>
				<td>구분</td>
				<td><sf:input type="text" name="part" path="part"/><br/>
				<sf:errors path="part" class="error"></sf:errors></td> 
			</tr>
			<tr>
				<td>학점</td>
				<td><sf:input type="text" name="grade" path="grade"/><br/>
				<sf:errors path="grade" class="error"></sf:errors></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="submit"></td>
			</tr>
		</table>
	</sf:form>

</body>
</html>
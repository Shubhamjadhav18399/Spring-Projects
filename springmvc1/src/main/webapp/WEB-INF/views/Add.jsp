<%@page import="com.jspiders.springmvc1.pojo.StudentPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavPage.jsp"></jsp:include>
<%
String msg = (String) request.getAttribute("msg");
List<StudentPOJO> students = (List<StudentPOJO>) request.getAttribute("students");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<fieldset>
			<legend>Add Student Details</legend>
			<form action="./add" method="post">
				<table>
					<tr>
						<td>Name:</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><input type="text" name="email"></td>
					</tr>
					<tr>
						<td>Contact:</td>
						<td><input type="text" name="contact"></td>
					</tr>
					<tr>
						<td>Address:</td>
						<td><input type="text" name="address"></td>
					</tr>
				</table>
				<input type="submit" value="SUBMIT">
			</form>
		</fieldset>
		<%
		if (msg != null) {
		%>
		<h3><%=msg%></h3>
		<%
		}
		%>

		<%
		if (students != null) {
		%>
		<table id="data" border="1px solid">
			<tr>
				<td>ID</td>
				<td>NAME</td>
				<td>EMAIL</td>
				<td>CONTACT</td>
				<td>ADDRESS</td>
			</tr>
			<%
			for (StudentPOJO pojo : students) {
			%>
			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getName()%></td>
				<td><%=pojo.getEmail()%></td>
				<td><%=pojo.getContact()%></td>
				<td><%=pojo.getAddress()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		%>
	</div>
</body>
</html>
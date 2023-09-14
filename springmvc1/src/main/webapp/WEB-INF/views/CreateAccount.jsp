<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<fieldset>
			<legend>Create Admin Account</legend>
			<form action="createAccount" method="post">
				<table>
					<tr>
						<td>UserName:</td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="text" name="password"></td>
					</tr>
				</table>
				<input type="submit" value="Create Account">
			</form>
		</fieldset>
	</div>
</body>
</html>
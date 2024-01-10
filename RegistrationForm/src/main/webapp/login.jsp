<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
body {
	font-family: Arial, sans-serif;
	background-color: #d3d3d3;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}
form {
	max-width: 400px;
	padding: 20px;
	background-color: #ffffff;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	border-radius: 8px;
}

form input[type="text"] {
	width: 100%;
	padding: 10px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 1px solid #ccc;
	border-radius: 4px;
}

form input[type="submit"] {
	background-color: #4caf50;
	color: #ffffff;
	padding: 10px 15px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

form input[type="submit"]:hover {
	background-color: #45a049;
}
</style>

</head>
<body>

	<form action="Login" method="post">
		<table>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="username" required></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="password" required></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="Submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>
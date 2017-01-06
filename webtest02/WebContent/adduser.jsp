<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="com.soft.domain.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>${msg}</p>
<form action="DoAddUser" method="post" >
<table>
	<tr>
		<td>用户名:</td>
		<td><input type="text" name="username" id="username" value="" /></td>
	</tr>
	<tr>
		<td>密码:</td>
		<td><input type="password" name="password" value=""/></td>
	</tr>
	<tr>
		<td>确认密码：</td>
		<td><input type="password" name="password02" value=""/></td>
	</tr>
	<tr>
		<td><input type="submit" name="sub" value="立即注册"/></td>
	</tr>

</table>
</form>
</body>
</html>
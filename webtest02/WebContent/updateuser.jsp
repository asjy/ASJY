<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="com.soft.domain.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	User user = (User)request.getAttribute("user");

%>


<form action="DoUpdateUser" method="post">
	<input type="hidden" name="id" value="<%=user.getId() %>" />
	<table>
		<tr>
			<td>用户名222:</td>
			<td>${user.username}</td>
		</tr>
		<tr>
			<td>密码:</td>
			<td><input type="password" name="password" value="<%=user.getPassword() %>" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" name="submit" value="修改" /></td>
		</tr>
	</table>
	
</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
你好
<%
	String str = "昨天下暴雨";
	for(int i=0; i<5; i++){
		out.print(str);
	}
%>
<form action="Index" method="post">
	用户名：<input type="text" name="username" value=""/>
	<input type="submit" name="sub" value="提交"/>
</form>
<a href="ShowUser">显示所有用户</a>
<a href="AddUserAddr">添加用户信息</a>
</body>
</html>
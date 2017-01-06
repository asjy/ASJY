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
<a href="AddUser">注册</a>
<table border="1px">
	<tr>
		<th>编号</th>
		<th>用户名</th>
		<th>密码</th>
		<th>所在班级</th>
		<th>注册时间</th>
		<th>操作</th>
	</tr>
	<%
		List<User> list_user = (List<User>)request.getAttribute("list_user");
// 		List<Classes> list_classes = (List<Classes>)request.getAttribute("list_classes");
		Map<Integer, String> map_classes = (Map<Integer, String>)request.getAttribute("map_classes");
		if(list_user != null && list_user.size() > 0){
			for(User user : list_user){
				out.print("<tr>");
				out.print("<td>"+user.getId()+"</td>");
				out.print("<td>"+user.getUsername()+"</td>");
				out.print("<td>"+user.getPassword()+"</td>");
				int classesid = user.getClassesid();
				String classesname = "";
// 				if(list_classes!=null && list_classes.size()>0){
// 					for(Classes classes : list_classes){
// 						if(classesid == classes.getId()){
// 							classesname = classes.getClassesname();
// 							break;
// 						}
// 					}
// 				}
				if(map_classes.containsKey(classesid)){
					classesname = map_classes.get(classesid);
				}
				out.print("<td>"+classesname+"</td>");
				out.print("<td>"+user.getAddtime().replace(".0", "")+"</td>");
				out.print("<td><a href='UpdateUser?id="+user.getId()+"'>编辑</a>  <a href='DelUser?id="+user.getId()+"'>删除</a></td>");
				out.print("</tr>");
			}
		}
		
	%>
</table>
</body>
</html>
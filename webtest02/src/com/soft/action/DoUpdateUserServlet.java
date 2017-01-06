package com.soft.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.domain.User;
import com.soft.service.UserService;

public class DoUpdateUserServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String password = req.getParameter("password");
		
		String id = req.getParameter("id");
		
		String msg = "";
		//非空校验
		if(password==null || "".equals(password)){
			msg = "请填写密码";
			req.setAttribute("msg", msg);
			//跳转页面
			RequestDispatcher dispatcher = req.getRequestDispatcher("/adduser.jsp");
			dispatcher.forward(req, resp);
			return;
		}
		//格式校验
		String reg = "[0-9a-zA-Z]{6,16}";
		if(!password.matches(reg)){
			msg = "请填写6到16位字母或数字组合的密码";
			req.setAttribute("msg", msg);
			//跳转页面
			RequestDispatcher dispatcher = req.getRequestDispatcher("/update.jsp");
			dispatcher.forward(req, resp);
			return;
		}
		
		//修改数据===========================================begin
		UserService userService = new UserService();
		User user = userService.findById(id);
		user.setPassword(password);
		userService.update(user);
		//修改数据===========================================end
		
//		List<User> list_user = userService.findAll();
//		req.setAttribute("list_user", list_user);
//		
		
		//跳转页面
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/ShowUser");
//		dispatcher.forward(req, resp);
		
		//重定向
		resp.sendRedirect("ShowUser");
		return;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	
	
}

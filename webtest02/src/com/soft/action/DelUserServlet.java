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

public class DelUserServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		UserService userService = new UserService();
		User user = new User();
		user.setId(Integer.parseInt(id));
		userService.delete(user);
		
		List<User> list_user = userService.findAll();
		req.setAttribute("list_user", list_user);
		//Ìø×ªÒ³Ãæ
		RequestDispatcher dispatcher = req.getRequestDispatcher("/showuser.jsp");
		dispatcher.forward(req, resp);
		return;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	
	
}

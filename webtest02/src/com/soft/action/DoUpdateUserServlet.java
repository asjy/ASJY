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
		//�ǿ�У��
		if(password==null || "".equals(password)){
			msg = "����д����";
			req.setAttribute("msg", msg);
			//��תҳ��
			RequestDispatcher dispatcher = req.getRequestDispatcher("/adduser.jsp");
			dispatcher.forward(req, resp);
			return;
		}
		//��ʽУ��
		String reg = "[0-9a-zA-Z]{6,16}";
		if(!password.matches(reg)){
			msg = "����д6��16λ��ĸ��������ϵ�����";
			req.setAttribute("msg", msg);
			//��תҳ��
			RequestDispatcher dispatcher = req.getRequestDispatcher("/update.jsp");
			dispatcher.forward(req, resp);
			return;
		}
		
		//�޸�����===========================================begin
		UserService userService = new UserService();
		User user = userService.findById(id);
		user.setPassword(password);
		userService.update(user);
		//�޸�����===========================================end
		
//		List<User> list_user = userService.findAll();
//		req.setAttribute("list_user", list_user);
//		
		
		//��תҳ��
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/ShowUser");
//		dispatcher.forward(req, resp);
		
		//�ض���
		resp.sendRedirect("ShowUser");
		return;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	
	
}

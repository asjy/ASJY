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

public class DoAddUserServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String username = req.getParameter("username");
		
		String password = req.getParameter("password");
		
		String password02 = req.getParameter("password02");
		
		String msg = "";
		//�ǿ�У��
		if(username==null || "".equals(username)){
			msg = "����д�û���";
			req.setAttribute("msg", msg);
			//��תҳ��
			RequestDispatcher dispatcher = req.getRequestDispatcher("/adduser.jsp");
			dispatcher.forward(req, resp);
			return;
		}
		if(password==null || "".equals(password)){
			msg = "����д����";
			req.setAttribute("msg", msg);
			//��תҳ��
			RequestDispatcher dispatcher = req.getRequestDispatcher("/adduser.jsp");
			dispatcher.forward(req, resp);
			return;
		}
		if(password02==null || "".equals(password02)){
			msg = "����дȷ������";
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
			RequestDispatcher dispatcher = req.getRequestDispatcher("/adduser.jsp");
			dispatcher.forward(req, resp);
			return;
		}
		
		//��Ч��У��
		if(!password.equals(password02)){
			msg = "�������벻һ�£�����������";
			req.setAttribute("msg", msg);
			//��תҳ��
			RequestDispatcher dispatcher = req.getRequestDispatcher("/adduser.jsp");
			dispatcher.forward(req, resp);
			return;
		}
		UserService userService = new UserService();
		User oldUser = userService.findByName(username);
		if(oldUser != null){
			msg = "�û���ע��";
			req.setAttribute("msg", msg);
			//��תҳ��
			RequestDispatcher dispatcher = req.getRequestDispatcher("/adduser.jsp");
			dispatcher.forward(req, resp);
			return;
		}
		
		//��������===========================================begin
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		userService.add(user);
		//��������===========================================end
		
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

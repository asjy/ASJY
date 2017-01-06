package com.soft.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.domain.Classes;
import com.soft.domain.User;
import com.soft.service.ClassesService;
import com.soft.service.UserService;

public class ShowUserServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		UserService userService = new UserService();
		List<User> list_user = userService.findAll();
		req.setAttribute("list_user", list_user);
		
		ClassesService classesService = new ClassesService();
		List<Classes> list_classes = classesService.findAll();
		req.setAttribute("list_classes", list_classes);
		
		Map<Integer, String> map_classes = new HashMap<Integer, String>();
		if(list_classes!=null && list_classes.size()>0){
			for(Classes classes : list_classes){
				map_classes.put(classes.getId(), classes.getClassesname());
			}
		}
		req.setAttribute("map_classes", map_classes);
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

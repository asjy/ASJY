package com.soft.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.domain.City;
import com.soft.service.CityService;

public class AddUserAddrServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		CityService cityService = new CityService();
		List<City> list_province = cityService.findProvince();
		req.setAttribute("list_province", list_province);
		//Ìø×ªÒ³Ãæ
		RequestDispatcher dispatcher = req.getRequestDispatcher("/addaddr.jsp");
		dispatcher.forward(req, resp);
		return;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	
	
}

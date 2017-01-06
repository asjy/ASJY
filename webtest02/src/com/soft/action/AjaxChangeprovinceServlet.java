package com.soft.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.domain.City;
import com.soft.service.CityService;

public class AjaxChangeprovinceServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader("Cache-Controll", "no-cache");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");;
		String checkvalue = req.getParameter("checkvalue");
		CityService cityService = new CityService();
		
//		List<City> list_province = cityService.findProvince();
		List<City> list_city = cityService.findCity(checkvalue);
//		req.setAttribute("list_province", list_province);
		//��תҳ��
		PrintWriter pw = resp.getWriter();
		//��ʼ��ƴ��json�õ��ַ���������
		StringBuffer sb = new StringBuffer();
		//����鵽��
		if(list_city != null && list_city.size() > 0){
			//ƴ�Ӳ�ѯ���
			sb.append("[");
			for (City c : list_city) {
				
				sb.append("{'name':'"+c.getCityname()+"','id':'"+c.getId()+"'},");
				
			}
			sb.append("]");
			//�����ַ���
			String name = sb.toString();
			//��ѯ���һ������Ķ���
			int num = name.lastIndexOf(",");
			//ȥ�����ය��
			name = name.substring(0, num)+"]";
			System.out.println(name);
			
			pw.write(name);
		}else{//û�ҵ�����û�ҵ��ı��
			pw.write("notfound");
		}
		
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	
	
}

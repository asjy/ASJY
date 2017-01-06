package com.soft.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.domain.City;
import com.soft.domain.User;
import com.soft.domain.UserAddr;
import com.soft.service.CityService;
import com.soft.service.UserAddrService;

public class DoAddUserAddrServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String provinceid = req.getParameter("provinceid");
		
		String cityid = req.getParameter("cityid");
		
		String districtid = req.getParameter("districtid");
		
		String receiver = req.getParameter("receiver");  //收货人
		String receiveraddr = req.getParameter("receiveraddr");  //详细地址
		String receivertel = req.getParameter("receivertel");    //联系电话
		
		UserAddrService userAddrService = new UserAddrService();
		CityService cityService = new CityService();
		City city1 = cityService.findByAllId(provinceid,cityid,districtid);
		
		
		UserAddr userAddr = new UserAddr();
		userAddr.setAddr(city1.getCityname());
		userAddr.setReceiveraddr(receiveraddr);
		userAddr.setReceivertel(Long.parseLong(receivertel));
		userAddrService.add(userAddr);
		
		
		
		//编辑的时候根据省市区地址查找id
		String addr2 =  userAddr.getAddr();
		String arr[] = addr2.split(" ");
		
		String pid = null;
		String cid = null;
		String did = null;
		for(int i=0; i<arr.length; i++){
			String a = arr[i];
			City city = cityService.findByName(a);
			if(i==0){
				pid = city.getId()+"";
				List<City> list_city = cityService.findCity(pid);
				req.setAttribute("list_city", list_city);
				System.out.println(pid);
			}
			if(i==1){
				cid = city.getId()+"";
				List<City> list_district = cityService.findCity(cid);
				req.setAttribute("list_district", list_district);
				System.out.println(cid);
			}
			if(i==2){
				did = city.getId()+"";
				System.out.println(did);
			}
		}
		
		req.setAttribute("pid", pid);
		req.setAttribute("cid", cid);
		req.setAttribute("desid", did);
		List<City> list_province = cityService.findProvince();
		req.setAttribute("list_province", list_province);
		
		//跳转页面
		RequestDispatcher dispatcher = req.getRequestDispatcher("/updateaddr.jsp");
		dispatcher.forward(req, resp);
		
		//重定向
//		resp.sendRedirect("ShowUser");
//		return;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	
	
}

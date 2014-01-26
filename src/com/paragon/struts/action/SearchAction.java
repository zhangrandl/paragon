/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.paragon.struts.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONArray;

import com.paragon.dao.HouseInfoDAO;
import com.paragon.entity.HouseInfo;
import com.paragon.struts.form.SearchForm;

/** 
 * MyEclipse Struts
 * Creation date: 01-16-2014
 * 
 * XDoclet definition:
 * @struts.action path="/search" name="searchForm" input="/search.jsp" parameter="method" scope="request" validate="true"
 */
public class SearchAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		SearchForm searchForm = (SearchForm) form;// TODO Auto-generated method stub
		String address = searchForm.getSearch_key();
//		System.out.print(searchForm.getSearch_key());
		
		HouseInfo house = new HouseInfo();
		HouseInfoDAO housedao = new HouseInfoDAO();
		List result = new ArrayList();
		
		if(address != null ){
			System.out.println("search");
			result = housedao.queryByLike(address);	
		}
		else{
			
			result = housedao.queryAll();
		}
		
		
		
		JSONArray json = new JSONArray();
		Map message = new HashMap();
		
		Iterator ite = result.iterator();
		while(ite.hasNext())
		{
			house = (HouseInfo)ite.next();
			int houseId = house.getHouseId();
			String houseaddress = house.getHouseAddress();
			int liveNum = house.getLiveNum();
			String housePicture = house.getHousePicture();
			String houseIntro = house.getHouseIntro();
			int housePrice = house.getHousePrice();
			String checkInTime = house.getCheckInTime();
			String checkOutTime = house.getCheckOutTime();
			String houseType = house.getHouseType();
			String rentType = house.getRentType();
			int houseArea = house.getHouseArea();
			int bedroomNum = house.getBedroomNum();
			
			
			//数据放入map中
			message.put("houseId", houseId);
			message.put("houseaddress", houseaddress);
			message.put("liveNum", liveNum);
			message.put("housePicture", housePicture);
			message.put("houseIntro", houseIntro);
			message.put("housePrice", housePrice);
			message.put("checkInTime", checkInTime);
			message.put("checkOutTime", checkOutTime);
			message.put("houseType", houseType);
			message.put("rentType", rentType);
			message.put("houseArea", houseArea);
			message.put("bedroomNum", bedroomNum);
			
			//map放入jsonarray
			json.put(message);
			
			
		}
		
		//构造jsonobject格式
		String respon_result = "{\"houselist\":"+ json +"}";
		
		response.setContentType("text/html; charset=utf-8");
		
		
		
		
		try {
			PrintWriter out = response.getWriter();
		    out.println(respon_result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}
	
}
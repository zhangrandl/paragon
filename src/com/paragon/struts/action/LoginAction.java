/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.paragon.struts.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.paragon.dao.UserDAO;
import com.paragon.struts.form.LoginForm;



/** 
 * MyEclipse Struts
 * Creation date: 01-13-2014
 * 
 * XDoclet definition:
 * @struts.action path="/login" name="loginForm" input="/login.jsp" parameter="method" scope="request" validate="true"
 */
public class LoginAction extends Action {
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
		LoginForm loginForm = (LoginForm) form;// TODO Auto-generated method stub
		int userid = loginForm.getUser_id();
		String user_regname = loginForm.getUser_regname();
		String password = loginForm.getUser_password();
		
		UserDAO userdao = new UserDAO();
		//User user = new User();
		//user.setUser_RegName(user_regname);
		//user.setPassword(password);
		boolean flag;
		flag = userdao.MalUser(user_regname, password);
		int userID = userdao.queryByRegName(user_regname);
		System.out.print(userID);
		
		 response.setContentType("text/html; charset=utf-8");
		
		if (flag) ;
		else{ 
			userID = 0;		
		 }
		try {
			PrintWriter out = response.getWriter();
		    out.print(userID);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		return null;
	}
}
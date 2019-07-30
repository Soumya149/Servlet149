
package com.login.DB;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.Controller.SetGet;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/profileDb1Action")
public class ProfileDb1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SetGet SetGet = new SetGet();
		SetGet.setId(request.getParameter("id"));
		SetGet.setName(request.getParameter("name"));
		SetGet.setMail(request.getParameter("mail"));
		SetGet.setMobile(request.getParameter("mobile"));
		
		
		//save
	     
		int res =  new ProfileDB().save(SetGet);
		System.out.println(res);
		request.setAttribute("RES", res);
		request.getRequestDispatcher("/ViewDataController").forward(request, response);
	}


	}

	

	
	



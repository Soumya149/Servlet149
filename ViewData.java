package com.login.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.Controller.SetGet;
import com.login.DB.ProfileDB;


/**
 * Servlet implementation class ViewData
 */
@WebServlet("/ViewDataController")
public class ViewData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("rawtypes")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int res = (int) request.getAttribute("RES");
		PrintWriter out = response.getWriter();
		if (res == 0)
			out.println("There is some problem ;  Try again .");
		else
			out.println("Data Successfully inserted");
		
		out.print(" <br/> The Datas are");
		List<SetGet> list = new ProfileDB().fetchAll();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			SetGet SetGet = (SetGet) iterator.next();
			out.println("Name : "+ SetGet.getName() +" Userid : "+ SetGet.getId()+ "mobile "+ SetGet.getMobile());
		}
		

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}

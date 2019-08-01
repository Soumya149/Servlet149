package com.maren.Democse.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestCtrl
 */
@WebServlet("/TestCtrl")
public class TestCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("REQ","Request Scope");
		HttpSession session=request.getSession();
		session.setAttribute("SES","Session Scope");
		ServletContext context=getServletContext();
		context.setAttribute("APP","Application Scope");
		RequestDispatcher rd= request.getRequestDispatcher("/ScopeCtrl");
		rd.forward(request,response);
	}

}

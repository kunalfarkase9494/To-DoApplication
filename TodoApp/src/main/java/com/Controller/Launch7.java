package com.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/updateNote")
public class Launch7 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("userid");
		String sNote = req.getParameter("sNote");
		
		HttpSession session = req.getSession();
		session.setAttribute("oldNote",sNote);
		
		resp.sendRedirect("updateNote.jsp");
	}
}

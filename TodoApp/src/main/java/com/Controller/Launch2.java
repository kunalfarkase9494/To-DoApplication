package com.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ConnectionFactory.ConnentionFactory;
import com.Dao.NotesDao;
import com.Dao.UserDao;
import com.Model.Note;

@WebServlet("/login")
public class Launch2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("userid");
		String pass = req.getParameter("password");
		
		Connection con = ConnentionFactory.getCon();
		UserDao uDao = new UserDao();
		
		NotesDao nDao = new NotesDao();
		ArrayList<Note> al = nDao.readAllNote(user, con);
		
		int ra = uDao.checkUser(user, pass, con);
		HttpSession session = req.getSession();
		
		if(ra==1) {
			session.setAttribute("al", al);
			session.setAttribute("check",user);
			resp.sendRedirect("home.jsp");
			
			
		}else {
			session.setAttribute("msg","*Invalid username or password");
			resp.sendRedirect("login.jsp");
		}
		
	}
}

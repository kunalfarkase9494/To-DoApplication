package com.Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ConnectionFactory.ConnentionFactory;
import com.Dao.NotesDao;
import com.Dao.UserDao;

@WebServlet("/signup")
public class Launch1 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("userid");
		String pass = req.getParameter("password");
		String email = req.getParameter("email");
		
		Connection con = ConnentionFactory.getCon();
		UserDao uDao = new UserDao();
		NotesDao nDao = new NotesDao();
		
		int ra = uDao.insertUser(user, pass, email, con);
		HttpSession session = req.getSession();
		
		
		
		if(ra==1) {
			session.setAttribute("msg","Account Created Successfully");
			nDao.createTableNote(user, con);
			resp.sendRedirect("login.jsp");
			
		}else {
			session.setAttribute("msg","*User Already Exist please enter another userid");
			resp.sendRedirect("signup.jsp");
		}
		
	}
}

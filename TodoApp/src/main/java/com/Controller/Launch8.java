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
import com.Model.Note;

@WebServlet("/updatedNote")
public class Launch8 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userid = req.getParameter("userid");
		String oldNote = req.getParameter("oldNote");
		String newNote = req.getParameter("newNote");
		
		Connection con = ConnentionFactory.getCon();
		NotesDao nDao = new NotesDao();
		nDao.updateNote(userid, oldNote, newNote, con);
		
		ArrayList<Note> al = nDao.readAllNote(userid, con);
		HttpSession session = req.getSession();
		session.setAttribute("al", al);
		
		resp.sendRedirect("home.jsp");
	}
}
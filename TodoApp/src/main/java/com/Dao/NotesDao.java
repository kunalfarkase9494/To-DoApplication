package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import com.Model.Note;


public class NotesDao {
	
	public void createTableNote(String userid,Connection con) {
		try {
			String sql = "create table "+userid+"notes(notedes varchar(255), adddate varchar(50), editDate varchar(50))";
			Statement st = con.createStatement();
			st.execute(sql);
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void addNote(String userid,String note,Connection con) {
		try {
			String sql = "insert into "+userid+"notes values(?,?,'no edit')";
			String addDate = LocalDate.now().toString();
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,note);
			ps.setString(2, addDate);
			ps.executeUpdate();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<Note> readAllNote(String userid,Connection con){
		
		ArrayList<Note> al = new ArrayList<>();
		try {
			
			String sql = "select * from "+userid+"notes";
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			while(rs.next()) {
				Note n = new Note();
				n.setNote(rs.getString(1));
				n.setAddDate(rs.getString(2));
				n.setEditDate(rs.getString(3));
				al.add(n);
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			return al;
		}
	}
	
	public void deleteNote(String userid,String note,Connection con) {
		try {
			String sql = "delete from "+userid+"notes where notedes=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,note);
			ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void updateNote(String userid,String oldNote,String newNote,Connection con)
	{
		try {
			String sql = "update "+userid+"notes set notedes=?,editDate=? where notedes=?";
			String editDate = LocalDate.now().toString();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1,newNote);
			ps.setString(2,editDate);
			ps.setString(3,oldNote);
			ps.executeUpdate();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
}

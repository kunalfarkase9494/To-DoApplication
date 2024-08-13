package com.Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
	int ra=0;
	public int insertUser(String userid,String password,String em,Connection con) {
		try {
			String sql = "insert into usersinfo values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userid);
			ps.setString(2, password);
			ps.setString(3, em);
			ra = ps.executeUpdate();
			if(ra==1) {
				return ra;
			}
		} 
		catch (Exception e) {
			System.err.println(e);
		}finally {
			return ra;
		}
	}
	
	public int checkUser(String userid,String password,Connection con) {
		try {
			String sql = "select * from usersinfo where userid=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,userid);
			ps.setString(2,password);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				ra=1;
			}	
			
		}
		catch (Exception e) {
			System.out.println(e);
		}finally {
			return ra;
		}
	}
}

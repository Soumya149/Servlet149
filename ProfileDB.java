package com.login.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.login.Controller.SetGet;

public class ProfileDB {
	public static Connection Conn()throws ClassNotFoundException,SQLException {
		return null;
		//Class.forName("com.mysql.jdbc.Driver");
		//return DriverManager.getConnection("jdbc:mysql://localhost/sakila", "root", "root");
}
	public int save(SetGet SetGet) {
		Connection con=null;
		Statement st=null;
		int res = 0;
		try {
			
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/sakila", "root", "root");
				
			
			st = con.createStatement();
			
			
				res = st.executeUpdate("INSERT INTO awt (id, name, mail, mobile) VALUES ('"+SetGet.getId()+"', '"+SetGet.getName()+"', '"+SetGet.getMail()+"', "+SetGet.getMobile()+")");
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					st.close();
					con.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return res;
		}
		
		public List<SetGet> fetchAll() {
			List<SetGet> list=null;
			Connection con = null;
			Statement st = null;
			
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/sakila", "root", "root");
					
				st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM awt");
				if(rs != null)
					list = new ArrayList<>();
				while(rs.next()) {
					SetGet pr = new SetGet();
					pr.setId(rs.getString("id"));
					pr.setName(rs.getString("name"));
					pr.setMail(rs.getString("mail"));
					pr.setMobile(rs.getString("mobile"));
					list.add(pr);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					st.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			return list;
		}
		public static void main(String[] args) {
			Connection con = null;
			Statement st = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/sakila", "root", "root");
				st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM awt");
				while(rs.next()) {
					String id = rs.getString("id");
					String name = rs.getString("name");
					String email = rs.getString("mail");
					long mobile = rs.getLong("mobile");
					System.out.println("Id : " +id + "\tName : "+ name+ "\tEmail : " + email + "\tMobile : " +mobile );
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					st.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			

		
	}

}

package com.js.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.js.dto.Customer;

public class CustomerCRUD {
	
	public static final String URL="jdbc:mysql://localhost:3306/product_store";
	public static final String USER="root";
	public static final String PWD="mysore123";
	public static final String PATH="com.mysql.cj.jdbc.Driver";
	
	
public static int insertCustomer(Customer c) {
		
		Connection con=null;
		String query="insert into customer values(?,?,?,?,?)";
		try {
			Class.forName(PATH);
			con=DriverManager.getConnection(URL, USER, PWD);
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, c.getId());
			ps.setString(2, c.getName());
			ps.setString(3, c.getEmail());
			ps.setInt(4, c.getPassword());
			ps.setLong(5, c.getPhone());
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}


public static boolean validateCustomer(String email, int password) {
	Connection con=null;
	String query="select * from customer where email=? and password=?";
	try {
		Class.forName(PATH);
		con=DriverManager.getConnection(URL, USER, PWD);
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, email);
		ps.setInt(2,password);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			return true;
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return false;
	
}
	

}

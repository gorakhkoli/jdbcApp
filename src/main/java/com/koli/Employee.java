package com.koli;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Employee
{
	Connection con =null;
	Statement statement = null;
	ResultSet resultSet =null;
	Employee()
	{
		try {
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/local1", "root", "root");
			statement = (Statement) con.createStatement();
			//resultSet =  statement.executeQuery("select * from employee");
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void getDetails()
	{
		//resultSet =  statement.executeQuery("select * from employee");
		try {
			resultSet =  statement.executeQuery("select * from employee");
			System.out.println("empId\tempname\tsalary");
			while(resultSet.next())
			{
				System.out.print(resultSet.getInt(1)+"\t");
				System.out.print(resultSet.getString(2)+"\t" );
				System.out.println(resultSet.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

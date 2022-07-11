package com.skillstorm.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExpensePractice {
	public static void main(String[] args) throws SQLException {

		// 1. Establish connection to database
		String url = "jdbc:mysql://localhost:3306/expensereimbursement";
		String username = "root";
		String password = "newtable";
		Connection connection = DriverManager.getConnection(url, username, password);

		// 2. Issue SQL statement
		String var = "beth";
		String sql = "insert into expenses(name) values (?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, var); // all ? must have value
		statement.executeUpdate();

		System.out.println("finished");
		// 3. Close connection
		connection.close();
	}

}
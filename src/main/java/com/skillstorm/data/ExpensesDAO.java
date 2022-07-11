package com.skillstorm.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.skillstorm.beans.Expenses;

public class ExpensesDAO {

	private Connection connection;

	public ExpensesDAO() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/expensereimbursement";
		String username = "root";
		String password = "newtable";
		this.connection = DriverManager.getConnection(url, username, password);
	}

	// create

	public Expenses create(Expenses expense) throws SQLException {
		String query = "insert into Expenses(Name, Amount, Reason, Status_id) values (?, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, expense.getName());
		statement.setDouble(2, expense.getPrice());
		statement.setString(3, expense.getReason());
		statement.setInt(4, expense.getStatusid());
		statement.executeUpdate();

		ResultSet rs = statement.getGeneratedKeys();

		rs.next();
		int generatedId = rs.getInt(1);
		expense.setId(generatedId);

		return expense;
	}

	// read

	public Set<Expenses> read() throws SQLException {
		Set<Expenses> expenseValues = new HashSet<Expenses>();
		String query = "select Exp_ID, Name, Amount, Reason, Status_id from Expenses";

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		while (resultSet.next()) {

			Expenses row = new Expenses();
			int id = resultSet.getInt("Exp_ID");
			String name = resultSet.getString("Name");
			double price = resultSet.getDouble("Amount");
			String reason = resultSet.getString("Reason");
			int statusid = resultSet.getInt("Status_id");

			row.setId(id);
			row.setName(name);
			row.setPrice(price);
			row.setReason(reason);
			row.setStatusid(statusid);

			expenseValues.add(row);
		}
		return expenseValues;
	}

	// update

	public boolean update(Expenses expense) throws SQLException {
		String query = "Update Expenses set Name = ? where EXP_ID = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, expense.getName());
		statement.setInt(2, expense.getId());
		return statement.executeUpdate() == 1;
	}

	// delete

	public boolean delete(int id) throws SQLException {
		String query = "Delete from Expenses where EXP_ID = ?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id);
		return statement.executeUpdate() == 1;
	}
}

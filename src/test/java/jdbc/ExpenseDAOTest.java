package jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.skillstorm.beans.Expenses;
import com.skillstorm.data.ExpensesDAO;

public class ExpenseDAOTest {

	static ExpensesDAO dao;

	@BeforeClass
	public static void setup() {
		try {
			dao = new ExpensesDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void create() {
		try {
			Expenses object = dao.create(new Expenses("test", 40.5, "target trip", 2));
			System.out.println(object);
		} catch (SQLException e) {
			e.printStackTrace();
			fail();
		}
	}

	
	@Test
	public void read() {
		try {
			Set<Expenses> expenses = dao.read();
			assertTrue(!expenses.isEmpty());
			System.out.println(expenses);
		} catch (SQLException e) {
			e.printStackTrace();
			fail();
		}
	}

	/*
	@Test
	public void update() {
		try {
			dao.update(new Expenses(2, "Todd", 0, null, 0));
		} catch (SQLException e) {

			e.printStackTrace();
			fail();
		}
	}
	

	
	@Test
	public void delete() {
		try {
			boolean deleted = dao.delete(2);
			assertTrue(deleted);
			System.out.println("deleted");
		} catch (SQLException e) {

			e.printStackTrace();
			fail();
		}

	}*/

}

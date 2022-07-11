package com.skillstorm.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.data.ExpensesDAO;

@WebServlet(urlPatterns = "/expenses")
public class ServletController extends HttpServlet {

	ExpensesDAO dao;

	@Override
	public void init() throws ServletException {
		try {
			dao = new ExpensesDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String param = req.getParameter("id");
			if(param != null) {
				int id = Integer.parseInt(param);
				System.out.println(id);
			}
			
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(dao.read());

			resp.getWriter().println(json);

			resp.setContentType("application/json");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

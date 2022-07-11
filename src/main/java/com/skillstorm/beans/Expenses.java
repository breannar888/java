package com.skillstorm.beans;

import java.util.HashSet;
import java.util.Set;

public class Expenses {

	private int id;
	private String name;
	private double amount;
	private String reason;
	private int status_id;

	Set<Expenses> expenseObj = new HashSet<>();

	public Expenses() {
	}

	public Expenses(String name, double amount, String reason, int status_id) {
		super();
		this.name = name;
		this.amount = amount;
		this.reason = reason;
		this.status_id = status_id;
	}

	public Expenses(int id, String name, double amount, String reason, int status_id) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.reason = reason;
		this.status_id = status_id;
	}

	public Set<Expenses> getExpenseObj() {
		return expenseObj;
	}

	public void setExpenseObj(Set<Expenses> expenseObj) {
		this.expenseObj = expenseObj;
	}

	@Override
	public String toString() {
		return "Expenses [id=" + id + ", name=" + name + ", price=" + amount + ", reason=" + reason + ", status_id="
				+ status_id + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return amount;
	}

	public void setPrice(double price) {
		this.amount = price;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getStatusid() {
		return status_id;
	}

	public void setStatusid(int status_id) {
		this.status_id = status_id;
	}

}

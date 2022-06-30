package com.order;

import java.time.LocalTime;
import java.util.Date;

public class OrderPojo {

	private int orderId;
	private String orderName;
	private int amount;
	private String status;
	Date orderDate = new Date();
	LocalTime TimeZone;
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public LocalTime getTimeZone() {
		return TimeZone;
	}
	public void setTimeZone(LocalTime timeZone) {
		TimeZone = timeZone;
	}
	public String toString() {
		return "[orderId= "+orderId+",orderName =" +orderName+",amount = " + amount+",status = "+ status + ",TimeZone=" +TimeZone+ "]";
	}
}

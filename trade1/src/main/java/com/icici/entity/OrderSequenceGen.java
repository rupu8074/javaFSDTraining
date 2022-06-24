package com.icici.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_seq_gen")
public class OrderSequenceGen {
	@Id
	private int id;
	private int order_current_value;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrder_current_value() {
		return order_current_value;
	}
	public void setOrder_current_value(int order_current_value) {
		this.order_current_value = order_current_value;
	}

	public String toString() {
		return "orderId " + id + "current value is " + order_current_value;
	}
	
	
}

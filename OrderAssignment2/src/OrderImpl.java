package com.order;

import java.time.LocalTime;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

public class OrderImpl {

	public int generateOrderId() {
		Random rm = new Random();
		int orderId = rm.nextInt(100);
		return orderId;
	}

	Optional<OrderPojo> orderNow(OrderPojo orderPojo) {
		Date date = new Date();
		Optional<OrderPojo> orderObj = Optional.of(orderPojo);
		int orderId = generateOrderId();
		orderPojo.setOrderDate(date);
		orderPojo.setOrderId(orderId);
		
		return orderObj;

	}
}

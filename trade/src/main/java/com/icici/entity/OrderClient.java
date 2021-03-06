
package com.icici.entity;

import java.util.List;

public class OrderClient {
	public static void main(String[] args) {
		OrderManagementImpl orderManagementDaoImpl = new OrderManagementImpl();

		// create Logic

		/*
		 * Order order = new Order(); order.setOrderName("Deepavali Purchase");
		 * order.setAmount(2000);
		 * 
		 * orderManagementDaoImpl.createOrder(order);
		 */

		// read Logic

		/*
		 * int orderId = 101; order = orderManagementDaoImpl.getOrder(orderId);
		 * 
		 * if(order == null) {
		 * System.out.println("Order Id "+orderId+" is not available."); } else {
		 * System.out.println(order.getOrderId());
		 * System.out.println(order.getOrderName()); }
		 */

		// update Logic

		/*
		 * Order order = new Order(); order.setOrderId(7);
		 * order.setOrderName("Durga Puja Purchase"); order.setAmount(8000);
		 * 
		 * orderManagementDaoImpl.updateOrder(order);
		 */

		// delete Logic

		/*
		 * int orderId = 9; orderManagementDaoImpl.deleteOrder(orderId);
		 */

		// listAllRows Logic

		/*
		 * List<Order> orderList = orderManagementDaoImpl.listAllRows();
		 * 
		 * if (orderList == null) { System.out.println("No order found."); } else { for
		 * (Order orderObj : orderList) { System.out.println();
		 * System.out.print("OrderId: "+orderObj.getOrderId());
		 * System.out.print(", OrderName: "+orderObj.getOrderName());
		 * System.out.print(", orderAmount: "+orderObj.getAmount());
		 * System.out.print(", Order Status: "+orderObj.getStatus()); } }
		 */

		// OrderByNameLike Logic

		/*
		 * List<Order> orderList = orderManagementDaoImpl.getOrderByNameLike("New");
		 * 
		 * if (orderList == null) { System.out.println("No order found."); } else { for
		 * (Order orderObj : orderList) { System.out.println();
		 * System.out.print("OrderId: "+orderObj.getOrderId());
		 * System.out.print(", OrderName: "+orderObj.getOrderName());
		 * System.out.print(", orderAmount: "+orderObj.getAmount());
		 * System.out.print(", Order Status: "+orderObj.getStatus()); } }
		 */

		// getOrderByNameLikeNamed Logic

		List<Order> orderList = orderManagementDaoImpl.getOrderByNameLike("New");

		if (orderList == null) {
			System.out.println("No order found.");
		} else {
			for (Order orderObj : orderList) {
				System.out.println();
				System.out.print("OrderId: " + orderObj.getOrderId());
				System.out.print(", OrderName: " + orderObj.getOrderName());
				System.out.print(", orderAmount: " + orderObj.getAmount());
				System.out.print(", Order Status: " + orderObj.getStatus());
			}
		}
	}
}

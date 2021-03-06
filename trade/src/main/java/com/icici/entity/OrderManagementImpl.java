package com.icici.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.icici.pojo.OrderPojo;

public class OrderManagementImpl {

	EntityManagerFactory emf = null;
	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	EntityManager getEntityManager() {
		try {
			emf = Persistence.createEntityManagerFactory("corebanking");
			entityManager = emf.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entityManager;
	}

	void closeEntityManagerFactory() {
		if (emf != null) {
			emf.close();
		}

	}

	void closeEntityManager() {
		if (entityManager != null) {
			entityManager.close();
		}

	}

	public void createOrder(Order order) {
		getEntityManager();
		try {
			transaction = entityManager.getTransaction();
			transaction.begin();
			OrderSequenceGen orderSeq = entityManager.find(OrderSequenceGen.class, 1);
			int orderSeqId = orderSeq.getOrder_current_value();
			int orderId = orderSeqId + 1;
			order.setOrderId(orderId);
			orderSeq.setOrder_current_value(orderId);
			// entity
			order.setOrderName(order.getOrderName());
			order.setAmount(order.getAmount());
			// save call
			System.out.println("order data is " + order);
			entityManager.persist(order);
			System.out.println(order);
			transaction.commit();
			entityManager.close();

			System.out.println("Order saved   successfull....");

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			closeEntityManagerFactory();
			closeEntityManager();

		}
	}

	Order getOrder(int orderId) {
		Order order = null;
		getEntityManager();
		try {
			System.out.println(orderId);
			order = entityManager.find(Order.class, orderId);
			System.out.println(order);
			System.out.println("OrderSaved Success");
		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			closeEntityManagerFactory();
			closeEntityManager();

		}
		return order;

	}

	Order updateOrder(Order order) {

		try {
			getEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			int orderId = order.getOrderId();
			System.out.println("order details is " + order);
			order = entityManager.find(Order.class, orderId);
			if (order == null) {
				System.out.println("Order not Available");
			} else {
				System.out.println("order details is " + order);
				order.setOrderName("Headsets");
				order.setAmount(1500);
				order.setStatus("Successfully ordered Headsets");
			}
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			closeEntityManagerFactory();
			closeEntityManager();

		}
		return order;

	}

	public void deleteOrder(int orderId) {
		try {
			Order order = new Order();
			getEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			System.out.println("order details is " + orderId);
			if (order.getOrderId() == orderId) {
				order = entityManager.getReference(Order.class, orderId);
				if (order == null) {
					System.out.println("Order not Available");
				} else {
					entityManager.remove(order);
					System.out.println("Order Deleted  Successfully");
				}
			} else {
				System.out.println("record not found");
			}
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			closeEntityManagerFactory();
			closeEntityManager();

		}

	}

	public List<Order> listOrder() {
		Order orderEntity = null;
		List<Order> orderList = null;
		try {
			getEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Query query = entityManager.createQuery("from Order");
			orderList = query.getResultList();
			System.out.println("orderList is " + orderList.size()+orderList);
			transaction.commit();

		} catch (Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			closeEntityManagerFactory();
			closeEntityManager();

		}
		return orderList;

	}
	
	List<Order> getOrderByNameLike(String orderName){
		Order orderEntity = null;
		List<Order> orderList = null;
		try {
		getEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createQuery("select e from Order e where e.ordername LIKE '" + orderName + "%");
		orderList = query.getResultList();
		System.out.println("orderList is " + orderList.size()+orderList);
		transaction.commit();

	} catch (Exception e) {
		System.out.println(e);
		if (transaction != null) {
			transaction.rollback();
		}
	} finally {
		closeEntityManagerFactory();
		closeEntityManager();

	}
	return orderList;

}

}

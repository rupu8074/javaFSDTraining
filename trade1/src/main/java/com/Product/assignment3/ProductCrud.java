package com.Product.assignment3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProductCrud {
	public void retrieveProduct(int productId) {
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			emf = Persistence.createEntityManagerFactory("corebanking");
			entityManager = emf.createEntityManager();

			transaction = entityManager.getTransaction();
			transaction.begin();
			Product p = entityManager.find(Product.class, productId);
			System.out.println("Product Name is " + p.getProductName());
			System.out.println("Product with given productId is :" + p);
			transaction.commit();
			entityManager.close();

			System.out.println("Product saved  successfull....");

		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			if (transaction != null && transaction.isActive()) {
				transaction.commit();
			}
			if (entityManager != null) {
				entityManager.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
	}
}
	

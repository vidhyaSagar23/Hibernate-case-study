package com.jsp.hibernate_case_study.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate_case_study.entity.Product;

public class ProductDa {
	
	Configuration cfg=new Configuration().configure().addAnnotatedClass(Product.class);
	SessionFactory sessionFactory=cfg.buildSessionFactory();
	Scanner sc=new Scanner(System.in);
	
	public String addProduct(Product product) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(product);
		transaction.commit();
		session.close();
		return "Product added successfully";
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProduct() {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query<Product> query=session.createQuery("from Product");
		List<Product> products=query.getResultList();
			transaction.commit();
			session.close();
			return products;
		}
	
//	get product by id
	public Product getProductById(int id) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Product product=session.get(Product.class, id);
		transaction.commit();
		session.close();
		return product;
	}

	public void updateProductById(Product product) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.update(product);
		transaction.commit();
		session.close();
	}
	
	public void deleteById(Product product) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.delete(product);
		transaction.commit();
		session.close();
	}
	

}	

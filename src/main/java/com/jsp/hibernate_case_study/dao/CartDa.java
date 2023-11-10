package com.jsp.hibernate_case_study.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate_case_study.entity.Cart;
import com.jsp.hibernate_case_study.entity.Product;

public final class CartDa {

	Configuration con=new Configuration().configure().addAnnotatedClass(Cart.class).addAnnotatedClass(Product.class);
	SessionFactory sessionFactory=con.buildSessionFactory();
	Scanner input=new Scanner(System.in);
//	add cart
	
	public String addCart(Cart cart) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(cart);
		transaction.commit();
		session.close();
		return "cart added";
	}
//	delete cart
	
//	add product to cart
	public String addProductToCart(Cart cart,Product product) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		cart.getProducts().add(product);
		session.update(cart);
		transaction.commit();
		session.close();
		return "Product added to cart";
	}

	public Cart getCartById(int cartId) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Cart cart=session.get(Cart.class, cartId);
		transaction.commit();
		session.close();
		return cart;
	}
	
//	delete cart by id
	public String deleteCartById(Cart cart) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.delete(Cart.class);
		transaction.commit();
		session.close();
		return "Deleted successfully";
	}
	
	
	
}
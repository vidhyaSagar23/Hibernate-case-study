package com.jsp.hibernate_case_study;

import java.util.Scanner;

import com.jsp.hibernate_case_study.dao.CartDa;
import com.jsp.hibernate_case_study.dao.ProductDa;
import com.jsp.hibernate_case_study.entity.Cart;
import com.jsp.hibernate_case_study.entity.Product;



public class CartService {
	static Scanner input = new Scanner(System.in);
	CartDa cartda=new CartDa();
	
//	To create cart
	
	public void createCart() {
		Cart cart=new Cart();
		String message=cartda.addCart(cart);
		System.out.println(message);
	}
//	to add product to cart
	
	public void addProductToCart() {
		System.out.println("enter the cart id");
		int cartId=input.nextInt();
		System.out.println("enter the Product id");
		int productId=input.nextInt();
		Cart cart=new CartDa().getCartById(cartId);
		Product product=new ProductDa().getProductById(productId);
		if(cart != null && product != null) {
			String message=cartda.addProductToCart(cart, product);
			System.out.println(message);
		}
		else {
			System.err.println("cart or product not found");
		}
	
	}
//	get cart by id
	public void getCartById() {
		System.out.println("enter cart id");
		int cartId=input.nextInt();
		Cart cart=cartda.getCartById(cartId);
		System.out.println(cart.getCartId());
	}
//	delete cart by id
	
	public void deleteCartById() {
		System.out.println("enter cart id");
		int cartId=input.nextInt();
		Cart cart=cartda.getCartById(cartId);
		if(cart != null) {
			
			cartda.deleteCartById(cart);
		}
		else {
			System.err.println("No cart found");
		}
	}
}

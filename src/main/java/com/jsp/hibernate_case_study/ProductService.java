package com.jsp.hibernate_case_study;

import java.util.List;
import java.util.Scanner;

import com.jsp.hibernate_case_study.dao.ProductDa;
import com.jsp.hibernate_case_study.entity.Product;

public class ProductService {

	Scanner input=new Scanner(System.in);
	ProductDa productda=new ProductDa();
	
//	To add product
	
	public void addProduct() {
		
		System.out.println("Enter the ProductName");
		String pname=input.next();
		
		System.out.println("Eneter the Product Price");
		double price=input.nextDouble();
		
		System.out.println("Enter the product Quantity");
		int quantity=input.nextInt();
		Product product=new Product();
		
		
		product.setProductName(pname);
		product.setProductPrice(price);
		product.setProductQuantity(quantity);
		
		String message=productda.addProduct(product);
		System.out.println(message);
	}
	
//	To Get all product
	
	public void getProduct() {
		List<Product> products = productda.getAllProduct();
		for(Product product:products) {
			System.out.println(product.getProductId()+" "+product.getProductName()+" "+product.getProductPrice()+" "+product.getProductQuantity());
		}
	}
//	get by id
	
	public void getProductById() {
		System.out.println("Enter the id");
		int id=input.nextInt();
		Product product=productda.getProductById(id);
		System.out.println(product.getProductId()+" "+product.getProductName()+" "+product.getProductPrice()+" "+product.getProductQuantity());
	}
	
//	Update record using id
	public void updateProduct() {
		System.out.println("Enter Id to be Updated");
		int id=input.nextInt();
		Product product=productda.getProductById(id);
		if(product != null) {
			System.out.println("Enter product name");
			String productName=input.next();
			product.setProductName(productName);
			productda.updateProductById(product);
			System.out.println("Update Successfull");
		}
		else {
			System.err.println("No id Found");
		}
	}
	
//	Delete by id
	
	public void deleteById() {
		System.out.println("Enter Id to be Deleted");
		int id=input.nextInt();
		Product product=productda.getProductById(id);
		if(product != null) {
			productda.deleteById(product);
			System.out.println("Deleted Successfully");
		}
		else {
			System.err.println("No id Found");
		}
	}
}

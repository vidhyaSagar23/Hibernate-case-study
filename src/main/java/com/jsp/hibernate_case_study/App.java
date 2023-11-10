package com.jsp.hibernate_case_study;

import java.util.Scanner;



public class App 
{
    public static void main( String[] args )
    {
    	Scanner input=new Scanner(System.in);
    	
    	System.out.println("1 : Product\n2 : Cart");
    	
    	int key=input.nextInt();
    	
    	if(key==1) {
    		
    	System.out.println("1 : Add Product\n2 : Get all product\n3 : Get produc by Id\n4 : Update record\n5 : Delete By id");
    	
    	int choice=input.nextInt();
    	ProductService productservice=new ProductService();
    	switch (choice) {
		case 1:
			
	    	productservice.addProduct();
			break;
		case 2:
			
	    	productservice.getProduct();
	    	break;
		case 3:
			productservice.getProductById();
			break;
		case 4:
			productservice.updateProduct();
			break;
		case 5:
			productservice.deleteById();
			break;
		default:
			System.err.println("Invalid choice");
			break;
		}
    	}
    	else if(key==2) {
    		CartService cartService=new CartService();
    		System.out.println("1 : createcart\n2 : get cart by Id\n3 : add Product to cart\n4 : delete by id");
    		int choice=input.nextInt();
    		switch(choice) {
    		case 1:
    			cartService.createCart();
    			break;
    		case 2:
    			cartService.getCartById();
    			break;
    		case 3:
    			cartService.addProductToCart();
    			break;
    		case 4:
    			cartService.deleteCartById();
    		default:
    				System.err.println("Invalid choice");
    		}
    		}
    		else {
    		System.err.println("invalid choice");
    		}	

    	input.close();
    	    	
    }
}

    	
    	
    	
    	
    	
 
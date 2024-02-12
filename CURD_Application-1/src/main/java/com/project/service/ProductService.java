package com.project.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Product;
import com.project.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo repo;
	
	public List<Product> getProduct()
	{
		List<Product> list=repo.findAll();
		return list;
	}
	
    public Product getProduct(int id) {
		
		Product product = null;
		try {
			product=repo.findById(id).get();
		}
		catch(Exception e) {
			System.out.println("Invaild ID Please enter correct ID:");
		}
		
		return product;
	}
    
 public Product deleteProduct(int id) {
		Product product = null;
		try {
			product=repo.findById(id).get();
             repo.delete(product); 
		}
		catch(Exception e) {
			System.out.println("Invaild ID Please enter correct ID to Delete Record:");
		}
		return product;
	}
   
   public Product addProduct(Product product) {
		
	   Product p=repo.save(product);
		System.out.println("product is successfully added ");
		
		return p;
	}
   
   public Product updateProduct(int id, Product product) {
	   
	   product.setId(id);
	   Product p=repo.save(product);
	   
	   return p;
	
	}
    

}

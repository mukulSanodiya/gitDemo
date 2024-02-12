package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Product;
import com.project.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	public ProductService service;

	@GetMapping
	public ResponseEntity<List<Product>> getProduct()
	{	
		List<Product> list=service.getProduct();
		
		if(list.size()<=0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else
			return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") int id)
	{
		Product product = service.getProduct(id);
		if(product==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else
			return ResponseEntity.ok(product);
			
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("id") int id)
	{
		try {
			service.deleteProduct(id);
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}		
	}
	
	@PostMapping
	public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product)
	{
		Product p=null;
				
			try{
				p=service.addProduct(product);
				return ResponseEntity.status(HttpStatus.CREATED).body(p);
				
			}
			catch(Exception e) {
				return  ResponseEntity.ok(p);
			}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id")int id,@Valid @RequestBody Product product)
	{

		Product product1 = service.getProduct(id);
		if(product1==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else {
			 product1=service.updateProduct(id, product);
			return ResponseEntity.ok(product1);
		}

	}

}

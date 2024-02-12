package com.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotEmpty(message = "Please Enter Product Name")
	private String productName;
	
	@NotEmpty(message = "Please Enter Product Description")
	private String productDescription;
	
	@Min(value = 1, message="Price not be zero or null")
	private int productPrice;
	
	@NotEmpty(message = "Please Enter Product Color")
	private String productColor;
	
}

package com.deloitte.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.product.model.Product;
import com.deloitte.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	//Method to fetch all product catalog resources
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<Product>> getAllProducts()
	{
		return new ResponseEntity<List<Product>>(productService.getAllProducts(),HttpStatus.OK);
	}
	
	//Method to create a product catalog resource
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Product> createProduct( @RequestBody Product product ) 
	{
		productService.createProduct(product);
		return new ResponseEntity<Product>(product,HttpStatus.CREATED);
	}
		
	//Method to delete a product catalog resource based on id
	@DeleteMapping("{productId}")
	private ResponseEntity<String> deleteProduct(@PathVariable("productId") Long productId) 
	{
		productService.deleteProduct(productId);
		return new ResponseEntity<String>("Product deleted successfully", HttpStatus.OK);
	}
	
}

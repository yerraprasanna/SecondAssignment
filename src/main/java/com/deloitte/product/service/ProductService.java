package com.deloitte.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.product.model.Product;
import com.deloitte.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepo;
	
	//getting all product catalog resources record by using the method findaAll() 
	public List<Product> getAllProducts() 
	{
		List<Product> products = new ArrayList<Product>();
		productRepo.findAll().forEach(product -> products.add(product));
		return products;
	}
	
	//saving a specific record by using the method save() of CrudRepository
	public void createProduct(Product product) 
	{
		productRepo.save(product);
	}
	
	//deleting a specific record by using the method deleteById() 
	public void deleteProduct(Long productId) 
	{
		productRepo.deleteById(productId);
	}
}

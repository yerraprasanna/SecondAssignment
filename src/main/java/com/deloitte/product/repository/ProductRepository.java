package com.deloitte.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deloitte.product.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>  {

}

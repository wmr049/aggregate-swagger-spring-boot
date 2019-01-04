package com.example.productservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

	public Product findByAccountId(String accountId);
	public Optional<Product> findById(String id);

}

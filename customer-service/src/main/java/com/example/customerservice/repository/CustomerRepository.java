package com.example.customerservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.customerservice.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

	public Customer findByPesel(String pesel);
	public Optional<Customer> findById(String id);

}

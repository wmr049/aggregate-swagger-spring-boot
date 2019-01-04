package com.example.transferservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.transferservice.model.Transfer;

public interface TransferRepository extends MongoRepository<Transfer, String> {

	public List<Transfer> findByRecipient(String recipient);
	public List<Transfer> findBySender(String sender);
	public Optional<Transfer> findById(String id);

}

package com.example.productservice.api;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.contract.Account;
import com.example.productservice.contract.AccountClient;
import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	private AccountClient accountClient;
	
	@Autowired
	ProductRepository repository;
	
	protected Logger logger = Logger.getLogger(ProductController.class.getName());
	
	@RequestMapping("/products/account/{accountId}")
	public Product findByPesel(@PathVariable("accountId") String accountId) {
		logger.info(String.format("Product.findByAccountId(%s)", accountId));
		return repository.findByAccountId(accountId);
	}
	
	@RequestMapping("/products")
	public List<Product> findAll() {
		logger.info("Product.findAll()");
		return repository.findAll();
	}
	
	@RequestMapping("/products/{id}")
	public Product findById(@PathVariable("id") String id) {
		logger.info(String.format("Product.findById(%s)", id));
		Product product = repository.findById(id).get();
		Account account =  accountClient.getAccount(id);
		product.setCustomerId(account.getCustomerId());
		return product;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/products")
	public Product add(@RequestBody Product product) {
		logger.info(String.format("Product.add(%s)", product));
		return repository.save(product);
	}
	
}

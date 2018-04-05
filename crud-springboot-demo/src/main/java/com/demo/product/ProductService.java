package com.demo.product;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	public EntityManager em;

	public ProductService(EntityManager em) {
		this.em = em;
	}
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll() {
		return (List<Product>) productRepository.findAll();
	}
	public Product save(Product product){
		return  productRepository.save(product);		
	}
}

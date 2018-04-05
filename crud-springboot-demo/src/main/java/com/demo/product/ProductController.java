package com.demo.product;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method=RequestMethod.GET,value="/product/all")
	public List<Product> get() {	
		return productService.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/product/save")
	public Product save(@RequestBody Product product) {		
		return productService.save(product);
	}
}

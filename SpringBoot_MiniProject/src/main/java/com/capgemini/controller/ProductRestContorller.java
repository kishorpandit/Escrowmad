package com.capgemini.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.Product;
import com.capgemini.service.IProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin("http://localhost:4200")
public class ProductRestContorller  {
	
	@Autowired
	private IProductService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveProduct(@RequestBody Product product){
		Logger log = org.slf4j.LoggerFactory.getLogger(ProductRestContorller.class);
		ResponseEntity<String> resp = null;
		try {
			log.info("About to call service.");
			Integer id = service.save(product);
			String body = "Product '"+id+"' Created.";
			resp = new ResponseEntity<String>(body,HttpStatus.OK);
		} catch (Exception e) {
			log.error("Exception -"+e.getMessage());
			resp = new ResponseEntity<String>("Unable to save Product.",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		log.info("Leaving Save Product Method");
		return resp;
	}
}

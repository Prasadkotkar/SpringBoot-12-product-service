package com.product_service.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product_service.model.Product;
import com.product_service.service.ProductServiceImpl;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	private final ProductServiceImpl productService;

	public ProductController(ProductServiceImpl productService) {
		this.productService = productService;
	}

	@PostMapping
	public ResponseEntity<?> saveProduct(@RequestBody Product product) {
		return new ResponseEntity<>(this.productService.saveProduct(product), HttpStatus.CREATED);
	}

	@DeleteMapping("{productId}")
	public void deleteProduct(@PathVariable Long productId) {
		this.productService.deleteProduct(productId);

	}

	@GetMapping
	public ResponseEntity<?> getAllProducts() {
		return ResponseEntity.ok(this.productService.findAllProduct());
	}

	@PutMapping("{productId}")
	public Optional<Product> updateProduct(@RequestBody Product product, @PathVariable("productId") Long productId) {
		return this.productService.updateProduct(product);

	}

}

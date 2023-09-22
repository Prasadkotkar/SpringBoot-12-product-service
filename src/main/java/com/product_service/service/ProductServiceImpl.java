package com.product_service.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.product_service.bean.IProductRepository;
import com.product_service.model.Product;

@Service
public class ProductServiceImpl {

	private final IProductRepository productRepository;

	public ProductServiceImpl(IProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Product saveProduct(Product product) {
		product.setCreateTime(LocalDateTime.now());
		return this.productRepository.save(product);
	}

	public void deleteProduct(Long productId) {
		this.productRepository.deleteById(productId);
	}

	public List<Product> findAllProduct() {
		return this.productRepository.findAll();
	}

	public Optional<Product> updateProduct(Product product) {
		Optional<Product> existingProduct = this.productRepository.findById(product.getId());

		if (existingProduct.isPresent()) {
			Product updateProduct = existingProduct.get();
			updateProduct.setName(product.getName());
			updateProduct.setPrice(product.getPrice());

			this.productRepository.saveAndFlush(updateProduct);
			return Optional.of(updateProduct);
		} else {
			return Optional.empty();
		}
	}

}

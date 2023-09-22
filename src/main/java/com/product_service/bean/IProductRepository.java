package com.product_service.bean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.product_service.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

}

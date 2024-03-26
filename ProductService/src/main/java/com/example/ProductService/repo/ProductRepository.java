package com.example.ProductService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProductService.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{

}

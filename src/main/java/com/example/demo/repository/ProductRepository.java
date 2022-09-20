package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Products;

public interface ProductRepository extends JpaRepository<Products, Long> {

Products findById(int id);
	
	@Query(nativeQuery = true, value = "SELECT * FROM Products p where p.category=1  ORDER BY likes DESC LIMIT 3 ")
	List<Products> getFourNFT();
}

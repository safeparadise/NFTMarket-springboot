package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Products;
@Repository
public interface ProductRepository extends JpaRepository<Products, Long>{

	Products findById(int id);

}

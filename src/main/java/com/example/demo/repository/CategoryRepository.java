package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Categorys;

public interface CategoryRepository extends JpaRepository<Categorys, Long>{
	Categorys findById(int id);
}

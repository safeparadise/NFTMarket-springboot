package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Collection;

public interface CollectionRepository extends JpaRepository<Collection, Long>{

	@Query(nativeQuery = true, value = "SELECT * FROM Collection c LIMIT 3 ")
	List<Collection> getThreeCollection();
	
	Collection findById(int id);
	
	void deleteById(int id);
}

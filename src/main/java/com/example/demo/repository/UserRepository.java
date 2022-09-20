package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	@Query(nativeQuery=true, value="select * from Users u limit 3")
	List<Users> getThreeUser();
	
	
	Users findByid(int id);
}

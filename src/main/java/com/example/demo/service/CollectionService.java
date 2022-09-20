package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Collection;
import com.example.demo.repository.CollectionRepository;

@Service
public class CollectionService {

	private CollectionRepository collectionRepository;
	
	@Autowired
	public CollectionService(CollectionRepository collectionRepository) {
		super();
		this.collectionRepository = collectionRepository;
	}
	
	public List<Collection> getThreeCollection(){
		return collectionRepository.getThreeCollection();
	}
	public List<Collection> getAllcollection(){
		return collectionRepository.findAll();
	}
	
	public Collection getCollection(int id){
		return collectionRepository.findById(id);
	}
	public Collection addCollection(Collection collection){
		return collectionRepository.save(collection);
	}
}

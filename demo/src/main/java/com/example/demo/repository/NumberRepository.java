package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.PhoneNumber;

public interface NumberRepository extends CrudRepository<PhoneNumber, String>{
	
}

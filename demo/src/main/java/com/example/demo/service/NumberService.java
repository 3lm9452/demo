package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PhoneNumber;
import com.example.demo.repository.NumberRepository;

@Service
public class NumberService {
	
	@Autowired NumberRepository numberRepository;
	
	public void save(PhoneNumber phoneNumber) {
		numberRepository.save(phoneNumber);
	}
	
	public List<PhoneNumber> findAll(){
		List<PhoneNumber> numbers = new ArrayList<PhoneNumber>();
		numberRepository.findAll().forEach(e -> numbers.add(e));
		return numbers;
	}

}

package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class NumberValidator {

	
	public boolean isValid(String number) {
		
		return number.matches("[0-9]{11}");

	}
	
}

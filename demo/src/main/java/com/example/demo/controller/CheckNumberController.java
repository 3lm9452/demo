package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.PhoneNumber;
import com.example.demo.service.NumberValidator;

@Controller
public class CheckNumberController {

	@Autowired NumberValidator validator;
	
	@GetMapping("/check")
	public String greetingForm(Model model) {
		model.addAttribute("phoneNumber", new PhoneNumber());
		return "check";
	}
	
	@PostMapping("/check")
	public String greetingSubmit(@ModelAttribute PhoneNumber phoneNumber, Model model) {
		model.addAttribute("phoneNumber", phoneNumber);
		String message;
	
		if(validator.isValid(phoneNumber.getNumber())) {
			message = "Number provided is valid";
		}else {
			message = "Number provided is invalid";
		}
	
		model.addAttribute("message", message);
		return "result";
	}

}
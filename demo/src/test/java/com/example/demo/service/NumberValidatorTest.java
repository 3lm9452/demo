package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberValidatorTest {

	NumberValidator validator = new NumberValidator();

	@Test
	void testIsValidSucceeds() {
		assertTrue(validator.isValid("12345678901"));
	}
	@Test
	void testIsValidFails() {
		assertFalse(validator.isValid("123456789"));
		assertFalse(validator.isValid("12345678901DELETE"));
		assertFalse(validator.isValid("123456789___DELETE"));
	}

}

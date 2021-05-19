package com.example.demo.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.PhoneNumber;
import com.example.demo.repository.NumberRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

@Service
public class FileProcessor {

	@Autowired NumberValidator numberValidator;
	@Autowired NumberService numberService;
	
	public void processFile(MultipartFile file) throws IOException {
		try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()))) {
            
			List<String[]> lines;
			try {
				lines = reader.readAll();
			} catch (CsvException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
			boolean firstLine = true;
			for(String[] line : lines) {
				if(firstLine) {
					firstLine = false;
					continue;
				}
            	String id = line[0];
            	String number = line[1];
            	Boolean valid = numberValidator.isValid(number);
            	PhoneNumber record = new PhoneNumber();
            	record.setId(id);
            	record.setNumber(number);
            	record.setValid(valid);
            	numberService.save(record);
            }
            
		}
	}

}

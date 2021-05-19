package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.opencsv.bean.CsvBindByName;

@Entity
public class PhoneNumber {

	private Boolean valid;

    @CsvBindByName(column = "sms_phone")
	private String number;

    @Id
    @CsvBindByName(column="id")
	private String id;
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "PhoneNumber [valid=" + valid + ", number=" + number + ", id=" + id + "]";
	}
	
	
}

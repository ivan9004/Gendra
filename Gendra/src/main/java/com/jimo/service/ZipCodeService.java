package com.jimo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jimo.entity.ZipCode;
import com.jimo.repo.ZipCodeRepo;

@Service
public class ZipCodeService {
	
	@Autowired
	ZipCodeRepo repo;
	
	public List<ZipCode> listAll(){
		return repo.findAll();
	}
	
	public List<ZipCode> findByZipCode(String zipCode) {
		return repo.findByZipCode(zipCode);
	}
}

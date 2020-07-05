package com.jimo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jimo.entity.ZipCode;

@Repository
public interface ZipCodeRepo extends JpaRepository<ZipCode, Integer>{
	
	@Query("SELECT z FROM ZipCode z WHERE z.zip_code = ?1")
	 List<ZipCode> findByZipCode(String zipCode);

}

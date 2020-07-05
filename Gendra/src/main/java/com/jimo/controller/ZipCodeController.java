package com.jimo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jimo.entity.ZipCode;
import com.jimo.exception.resource.ZipCodeNotFoundException;
import com.jimo.service.ZipCodeService;

@RestController
@RequestMapping("zip/v1")
public class ZipCodeController {

	@Autowired
	ZipCodeService service;

	/**
	 * Método para enlistar los códigos postales en la base de datos
	 * 
	 * @return Se retorna un elemento de tipo lista con los códigos postales en la
	 *         base de datos
	 */
	@GetMapping(path = "zipcode", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ZipCode>> listAll() {
		List<ZipCode> list = service.listAll();
		return ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(list);
	}

	/**
	 * Método que permite encontrar un código postal en especifico
	 * 
	 * @param zipCode Se recibe un tipo de dato String para realizar la búsqueda
	 * @return Retorna un tipo de dato Lista que contiene los códigos postales que
	 *         coinciden con el dado por el usuario
	 */
	@GetMapping("/find/{zipCode}")
	public ResponseEntity<List<ZipCode>> getZipCode(@PathVariable("zipCode") String zipCode) {
		List<ZipCode> zipCodeResult = service.findByZipCode(zipCode);
		if (!zipCodeResult.isEmpty()) {
			return ResponseEntity.ok().body(zipCodeResult);
		} else {
			throw new ZipCodeNotFoundException("No existe el codigo postal: " + zipCode);
		}

	}

}

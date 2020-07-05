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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("zip/v1")
@Api(value = "API REST realizada para la consulta de códigos postales de la Ciudad de Mexcio")
public class ZipCodeController {

	@Autowired
	ZipCodeService service;

	@GetMapping(path = "zip-codes", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Este método lista todos los códigos postales existentes en la base de datos", response = List.class)
	public ResponseEntity<List<ZipCode>> listAll() {
		List<ZipCode> list = service.listAll();
		return ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(list);
	}

	@GetMapping("/zip-codes/{zipCode}")
	@ApiOperation(value = "Este método lista todos los códigos postales existentes en la base de datos con el valor dado", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "No existe el codigo postal:") })
	public ResponseEntity<List<ZipCode>> getZipCode(
			@ApiParam(value = "Se requiere el código postal que desea buscar un ejemplo: 1400", required = true) @PathVariable("zipCode") String zipCode) {
		List<ZipCode> zipCodeResult = service.findByZipCode(zipCode);
		if (!zipCodeResult.isEmpty()) {
			return ResponseEntity.ok().body(zipCodeResult);
		} else {
			throw new ZipCodeNotFoundException("No existe el codigo postal: " + zipCode);
		}

	}

}

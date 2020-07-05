package com.jimo.test.api;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.jimo.controller.ZipCodeController;
import com.jimo.entity.Settlements;
import com.jimo.entity.ZipCode;
import com.jimo.service.ZipCodeService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ZipCodeController.class)
public class ZipCodeResourceTesting {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ZipCodeService zipCodeService;

	List<ZipCode> zipCodeList = Arrays.asList(new ZipCode(1, "1389", "Ciudad de Mexico", "Ciudad de Mexico",
			new Settlements(1, "'Santa Fe Tlayapaca'", "'Urbano'", "'Colonia'"), "Alvaro Obregon"));

	@Test
	public void zipCodeTest() throws Exception {

		Mockito.when(zipCodeService.findByZipCode("1389")).thenReturn(zipCodeList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8080/zip/v1/find/1389")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "[{\"id_zip\":1,\"zip_code\":\"1389\",\"locality\":\"Ciudad de Mexico\",\"federal_entity\":\"Ciudad de Mexico\",\"settlement\":{\"settlement_id\":1,\"name\":\"'Santa Fe Tlayapaca'\",\"zona_type\":\"'Urbano'\",\"settlement_type\":\"'Colonia'\"},\"municipality\":\"Alvaro Obregon\"}]";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

	}
}

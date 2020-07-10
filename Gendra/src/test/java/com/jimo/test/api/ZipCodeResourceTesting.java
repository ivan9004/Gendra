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

	List<ZipCode> zipCodeList = Arrays.asList(new ZipCode(3, 31009, "Chihuahua", "Chihuahua", 
			Arrays.asList( new Settlements(9, "'Palacio de Gobierno del Estado de Chihuahua'", "'Urbano' ", "'Gran usuario'", 31009)), "Chihuahua"));
	
			

	@Test
	public void zipCodeTest() throws Exception {

		Mockito.when(zipCodeService.findByZipCode(31009)).thenReturn(zipCodeList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("https://gendra-281916.uc.r.appspot.com/zip/v1/zip-codes/31009")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "[{\"id_zip\":3,\"zip_code\":31009,\"locality\":\"Chihuahua\",\"federal_entity\":\"Chihuahua\",\"settlement\":[{\"settlement_id\":9,\"name\":\"'Palacio de Gobierno del Estado de Chihuahua'\",\"zona_type\":\"'Urbano' \",\"settlement_type\":\"'Gran usuario'\",\"zip_code_settlement\":31009}],\"municipality\":\"Chihuahua\"}]";
				
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

	}
}

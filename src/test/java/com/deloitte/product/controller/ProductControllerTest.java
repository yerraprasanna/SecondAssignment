package com.deloitte.product.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {


	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testDeleteProduct() throws Exception {
		String testEndpoint = "/product/1";
		this.mockMvc.perform(delete(testEndpoint)).andExpect(status().isOk());
	}

}

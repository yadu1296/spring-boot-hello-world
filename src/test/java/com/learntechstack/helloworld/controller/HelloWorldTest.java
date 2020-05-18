package com.learntechstack.helloworld.controller;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = HelloWorldController.class)
public class HelloWorldTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void sayHelloWorld() {
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/sayHello").accept(
				MediaType.TEXT_PLAIN);
		
		try {
			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			
			String expected = "Hello World...!!!";
			
			assertEquals(expected, result.getResponse().getContentAsString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

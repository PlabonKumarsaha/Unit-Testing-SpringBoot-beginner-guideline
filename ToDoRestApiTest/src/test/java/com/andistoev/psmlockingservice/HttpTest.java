package com.andistoev.psmlockingservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@SpringBootTest
@AutoConfigureMockMvc
public class HttpTest {
	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate; //spring provides this

	
	 /*  @Test
		public void greetingShouldReturnDefaultMessage() throws Exception {
	    	//http://localhost:8080/api/
	   	System.out.print("i am in");
			assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/",
					String.class)).contains("Hello, World");
		} */


}

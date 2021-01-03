package com.andistoev.psmlockingservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.teksoi.restapi.controller.ToDoController;
import com.teksoi.restapi.service.ToDoService;
import com.teksoi.restapi.service.impl.ToDoServiceImpl;

@WebMvcTest(ToDoController.class)
public class TestController {


//	@Autowired
//	private MockMvc mockMvc;
//	@MockBean
//	ToDoService toDoService;
//	ToDoServiceImpl toDoService2;
//	  
//	  @Test
//	  public void testCOntrollerWithService() {
//		  System.out.println(toDoService2.inToDoService);
//		  
//		  when(toDoService.greet()).thenReturn("Hello, World");
//		  
//		  try {
//			this.mockMvc.perform(get("/api/greeting")).andDo(print()).andExpect(status().isOk())
//			  .andExpect(content().string(containsString("Hello, World")));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	  }
	  
		@Autowired
		private MockMvc mockMvc;

		@Test
		public void shouldReturnDefaultMessage() throws Exception {
			this.mockMvc.perform(get("/api/")).andDo(print()).andExpect(status().isOk())
					.andExpect(content().string(containsString("Hello, World")));
		}
}

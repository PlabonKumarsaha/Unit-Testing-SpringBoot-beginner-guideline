package com.andistoev.psmlockingservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.teksoi.restapi.controller.ToDoController;
import com.teksoi.restapi.service.ToDoService;

@SpringBootTest
public class CheckDefaultMessage {
	
	
	@MockBean
	ToDoService toDoService; 
	
	  @Test
	    public void contextLoads() throws Exception{
	    	ToDoController toDoController = new ToDoController(toDoService); 
	    	assertThat(toDoController).isNotNull();
	     	  	
	    } 

}

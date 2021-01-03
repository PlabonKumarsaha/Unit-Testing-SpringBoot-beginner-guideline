package com.andistoev.psmlockingservice;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import com.teksoi.restapi.controller.ToDoController;
import com.teksoi.restapi.model.ToDo;
import com.teksoi.restapi.repository.ToDoRepository;
import com.teksoi.restapi.service.ToDoService;

//@SpringBootTest
@DataJpaTest
@WebMvcTest(ToDoController.class)
public class TestingWebApplicationTests {
	
	
	@Autowired
	ToDoController toDoController;
	//MockMvc mockMvc;
	@MockBean
	ToDoService toDoService;
//	TestingWebApplicationTests(ToDoController toDoController){
//		this.toDoController = toDoController;
//	}
    @Test
    public void contextLoads() throws Exception{
    	ToDoController toDoController = new ToDoController(toDoService);
    //	System.out.print("message : "+toDoController.toString());
    	assertThat(toDoController).isNotNull();
    	//System.out.println("hello");
    	//System.out.print(toDoController.test);    	  	
    }
    
    @Autowired
    ToDoRepository toDoRepository;
    
    @Test
    public void contextService() throws Exception{
    	
    	//System.out.println(toDoRepository.finaltest);
    	//String sDate1="31-12-1998";  
      //  Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);  
       ToDo toDo = new ToDo();
       toDo.setId(2L);
       toDo.setTitle("I am a title");
       toDo.setDescription("svdjbdjabdjabdjabdajdbja");
      // toDo.setEventDate(date1);
      // System.out.println(toDo);
      // System.out.println(toDoRepository.finaltest);
     // toDoRepository.save(toDo);
       
      // ToDo getTodo = toDoRepository.getOne(1L);
       
       //if(toDo2 !=null) {
    	   
    	// assertTha
    	 //  System.out.println(getTodo==toDo2);
    //   }
      // when(toDO)
    	
    	ToDo savedProduct = toDoRepository.save(toDo);
        
        assertThat(savedProduct.getId()).isGreaterThan(0);
    }
    


}

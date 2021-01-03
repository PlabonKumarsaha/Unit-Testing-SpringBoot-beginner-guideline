package com.andistoev.psmlockingservice;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.teksoi.restapi.dto.Response;
import com.teksoi.restapi.dto.ToDoDto;
import com.teksoi.restapi.model.ToDo;
import com.teksoi.restapi.repository.ToDoRepository;
import com.teksoi.restapi.service.ToDoService;

//@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class CRUDTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	ToDoRepository toDoRepository;
	@InjectMocks
	ToDoService toDoService;
@Test
void isBeingadded() {
	 String sDate1="31-12-1998";  
     try {
		Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
    ToDoDto toDo = new ToDoDto();
    toDo.setId(1L);
    toDo.setTitle("title");
    toDo.setDescription("svdjbdjabdjabdjabdajdbja");
   // toDoService.create(toDo);
    //Mockito.when(toDoRepository.findByTitle("title")).thenReturn(null);
    Long result = toDoService.create(toDo);
    assertEquals("Created successfully", result);
}

	
}

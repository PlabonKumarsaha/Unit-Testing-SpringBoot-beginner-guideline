package com.andistoev.psmlockingservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.teksoi.restapi.dto.ToDoDto;
import com.teksoi.restapi.repository.ToDoRepository;
import com.teksoi.restapi.service.ToDoService;
import com.teksoi.restapi.service.impl.ToDoServiceImpl;

public class TestService {
	//@Autowired
	//ToDoRepository toDoRepository;
//	@Autowired
//	ToDoService toDoService;
	//@Autowired
	//ModelMapper modelMapper;
	@Test
	public void testCreate() {
		//System.out.println(toDoRepository.finaltest);
		// = new ModelMapper();	
		ToDoDto toDoDto = new ToDoDto();
		toDoDto.setId(1L);
		toDoDto.setEventDate(null);	
		toDoDto.setTitle("abc");
		toDoDto.setDescription("sgajbdjadbad");
		//toDoServiceImpl.
		
		ToDoService toDoServiceMock = mock(ToDoService.class);
		when(toDoServiceMock.create(toDoDto)).thenReturn(1L);
		//= new ToDoServiceImpl(toDoRepository,modelMapper);
		System.out.println(toDoServiceMock.inToDoService);
		Long val = (Long) toDoServiceMock.create(toDoDto);
//		boolean  test = false;
//		if(val.equals("sucessfull")) {
//			test = true;
//		}
		//assertEquals(1L, val);
		if(val == 1L) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
	}
}

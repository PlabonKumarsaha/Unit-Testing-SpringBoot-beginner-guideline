package com.teksoi.restapi.service;

import com.teksoi.restapi.dto.Response;
import com.teksoi.restapi.dto.ToDoDto;

public interface ToDoService {
	public String inToDoService = "in the to do service";
   // Response create(ToDoDto toDoDto);
	Long create(ToDoDto toDoDto);
   String greet();

  //  Response getAll();

    Response update(Long id, ToDoDto toDoDto);

    Response delete(Long id);

   // Response deleteAll();
}

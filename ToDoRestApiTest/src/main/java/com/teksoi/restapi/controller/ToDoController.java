package com.teksoi.restapi.controller;

import com.teksoi.restapi.dto.Response;
import com.teksoi.restapi.dto.ToDoDto;
import com.teksoi.restapi.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ToDoController {
	//public String test = "in controller";

    private final ToDoService toDoService;
   
    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

   @RequestMapping("/")
   @ResponseBody
   public String returnSomething() {
   	return "Hello, World"; 
   	}
   @RequestMapping("/greeting")
	public @ResponseBody String greeting() {
		return toDoService.greet();
	}

    @PostMapping("/todo")
    @ResponseBody
    public Long create(@RequestBody ToDoDto toDoDto, HttpServletResponse httpServletResponse, HttpServletRequest request) {
    	Long response = toDoService.create(toDoDto);
       // httpServletResponse.setStatus(response.getStatusCode());
        return response;
    }

//    @GetMapping("/todo")
//    @ResponseBody
//    public Response getAll(HttpServletResponse httpServletResponse) {//To make it simple pagination has not been implemented
//
//        Response response = toDoService.getAll();
//        httpServletResponse.setStatus(response.getStatusCode());
//        return response;
//    }

    @PutMapping("/todo/{id}")
    @ResponseBody
    public Response update(@PathVariable("id") Long id, @RequestBody ToDoDto toDoDto, HttpServletResponse httpServletResponse, HttpServletRequest request) {
        Response response = toDoService.update(id, toDoDto);
        httpServletResponse.setStatus(response.getStatusCode());
        return response;
    }

    @DeleteMapping("/todo/{id}")
    @ResponseBody
    public Response delete(@PathVariable("id") Long id, HttpServletResponse httpServletResponse, HttpServletRequest request) {
        Response response = toDoService.delete(id);
        httpServletResponse.setStatus(response.getStatusCode());
        return response;
    }

//    @DeleteMapping("/todo")
//    @ResponseBody
//    public Response delete(HttpServletResponse httpServletResponse) {
//        Response response = toDoService.deleteAll();
//        httpServletResponse.setStatus(response.getStatusCode());
//        return response;
//    }

}

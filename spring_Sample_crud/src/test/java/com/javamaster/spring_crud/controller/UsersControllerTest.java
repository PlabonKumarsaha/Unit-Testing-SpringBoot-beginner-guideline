package com.javamaster.spring_crud.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javamaster.spring_crud.dto.UsersDto;
import com.javamaster.spring_crud.service.UsersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static com.javamaster.spring_crud.prototype.UsersPrototype.aUserDTO;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsersController.class)
class UsersControllerTest {

	@Autowired
    MockMvc mockMvc;
	@Autowired
    ObjectMapper objectMapper;
    @MockBean
    UsersService usersService;
   // @Autowired
   // UsersController usersController;
    UsersDto userDto;
    @BeforeEach
    void setUp() {
       // usersService = mock(UsersService.class);
      //  mockMvc = MockMvcBuilders.standaloneSetup(new UsersController(usersService)).build();
       
    	//objectMapper = new ObjectMapper();
         userDto=  UsersDto.builder()
        .name("test_name")
        .login("test_login")
        .build();
    }

    @Test
    void saveUsers() throws Exception {
        when(usersService.saveUser(any())).thenReturn(userDto);
        mockMvc.perform(post("/users/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDto)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(userDto)));
    }

    @Test
    void findAllUsers() throws Exception {
        when(usersService.findAll()).thenReturn(Collections.singletonList(userDto));
        mockMvc.perform(get("/users/findAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(Collections.singletonList(aUserDTO()))))
                .andExpect(status().isOk());
    }

  
}

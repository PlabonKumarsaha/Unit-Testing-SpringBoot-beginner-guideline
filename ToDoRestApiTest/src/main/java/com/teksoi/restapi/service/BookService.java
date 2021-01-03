package com.teksoi.restapi.service;

import org.springframework.stereotype.Service;

import com.teksoi.restapi.model.Book;
import com.teksoi.restapi.repository.BookReposity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookService {
	
	private final BookReposity bookReposity;
	
	public Book getBookById(Long id){
		return bookReposity.findById(id).orElse(null);
	}

}

package com.teksoi.restapi.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teksoi.restapi.model.Book;
import com.teksoi.restapi.model.Comment;
import com.teksoi.restapi.model.Post;
import com.teksoi.restapi.service.BookService;
import com.teksoi.restapi.service.CommentService;
import com.teksoi.restapi.service.PostService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api")
public class CommentController {
	
	private final CommentService commentService;
	private final BookService bookService;
	private final PostService postService; 
	
	@GetMapping("/comment/{id}")
	public ResponseEntity<List<Comment>> getAllByBook(@PathVariable Long id){
		Book book = bookService.getBookById(id);
		Post post = postService.getPostByBook(book);
		return new ResponseEntity<>(commentService.findAllByPost(post),HttpStatus.OK);
	}
	
	@GetMapping("/comment/test")
	public String test(){
		return "Hello";
	}

}

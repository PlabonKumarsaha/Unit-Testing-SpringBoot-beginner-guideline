package com.teksoi.restapi.service;

import org.springframework.stereotype.Service;

import com.teksoi.restapi.model.Book;
import com.teksoi.restapi.model.Post;
import com.teksoi.restapi.repository.PostRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostService {
	
	private final PostRepository postRepository;
	
	public Post getPostByBook(Book book){
		return postRepository.findByBook(book);
	}
}

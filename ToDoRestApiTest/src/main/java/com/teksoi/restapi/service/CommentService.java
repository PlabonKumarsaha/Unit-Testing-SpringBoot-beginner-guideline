package com.teksoi.restapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teksoi.restapi.model.Comment;
import com.teksoi.restapi.model.Post;
import com.teksoi.restapi.repository.CommentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CommentService {
	
	private final CommentRepository commentRepository;
	
	public List<Comment> findAllByPost(Post post){
		return commentRepository.findAllByPost(post);
	}

}
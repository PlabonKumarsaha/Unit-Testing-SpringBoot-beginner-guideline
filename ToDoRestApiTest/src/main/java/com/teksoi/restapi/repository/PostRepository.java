package com.teksoi.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teksoi.restapi.model.Book;
import com.teksoi.restapi.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
	Post findByBook(Book book);
}
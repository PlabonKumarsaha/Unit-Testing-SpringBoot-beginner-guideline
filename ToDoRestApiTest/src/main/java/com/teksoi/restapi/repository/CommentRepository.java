package com.teksoi.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teksoi.restapi.model.Comment;
import com.teksoi.restapi.model.Post;

public interface CommentRepository extends JpaRepository< Comment, Long>{

	List<Comment> findAllByPost(Post post);
}

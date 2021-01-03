package com.teksoi.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teksoi.restapi.model.Book;

public interface BookReposity extends JpaRepository<Book, Long>{

}

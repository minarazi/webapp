package com.mina.springframework.springwebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mina.springframework.springwebapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}

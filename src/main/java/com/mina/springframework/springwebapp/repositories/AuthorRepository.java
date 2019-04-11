package com.mina.springframework.springwebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mina.springframework.springwebapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}

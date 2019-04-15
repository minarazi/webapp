package com.mina.springframework.springwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mina.springframework.springwebapp.repositories.BookRepository;

@Controller
public class BookController {

	private BookRepository bookRepository;

	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@RequestMapping("/get-books")
		 String getBooks(Model model) {

		model.addAttribute("allBooks", bookRepository.findAll());
		
		return "bookPage";

	}

}

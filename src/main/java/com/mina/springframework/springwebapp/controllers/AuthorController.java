package com.mina.springframework.springwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mina.springframework.springwebapp.repositories.AuthorRepository;

@Controller
public class AuthorController {

	private AuthorRepository authorRepository;

	public AuthorController(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@RequestMapping("/get-authors")
	public String getAuthor(Model model) {

		model.addAttribute("allAuthors", authorRepository.findAll());
		return "authorPage";
	}

}

package com.mina.springframework.springwebapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.mina.springframework.springwebapp.model.Author;
import com.mina.springframework.springwebapp.model.Book;
import com.mina.springframework.springwebapp.model.Publisher;
import com.mina.springframework.springwebapp.repositories.AuthorRepository;
import com.mina.springframework.springwebapp.repositories.BookRepository;
import com.mina.springframework.springwebapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {

		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();

	}

	private void initData() {

		Publisher publisher = new Publisher();
		publisher.setName("foo");

		publisherRepository.save(publisher);

		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", publisher);
		eric.getBooks().add(ddd);
		ddd.getAuthers().add(eric);

		authorRepository.save(eric);
		bookRepository.save(ddd);

		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development Without EJB", "2344", publisher);
		rod.getBooks().add(noEJB);

		authorRepository.save(rod);
		bookRepository.save(noEJB);
	}

}

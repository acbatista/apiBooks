package com.project.apiBooks.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.apiBooks.domain.Book;
import com.project.apiBooks.repository.BooksRepository;

@RestController
@RequestMapping(value="/books")
public class BooksResources {
	
	@Autowired
	private BooksRepository booksRepository;

	@RequestMapping(method= RequestMethod.GET)
	public List<Book> list() {
		
		return booksRepository.findAll();
		
	};
	
	@RequestMapping(method= RequestMethod.POST)
	public void save(@RequestBody Book book) {
		booksRepository.save(book);
	}
	
	@RequestMapping(value = "/{id}",method= RequestMethod.GET)
	public Book findOne(@PathVariable("id") Long id) {
		return booksRepository.findOne(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		booksRepository.delete(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void update(@RequestBody Book book, @PathVariable("id") Long id) {
		book.setId(id);
		booksRepository.save(book);
	}
	
}

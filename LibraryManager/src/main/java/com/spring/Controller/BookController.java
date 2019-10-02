package com.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Model.Book;
import com.spring.service.BookService;

@RestController	
public class BookController {
	@Autowired
	private BookService bookService;
	@GetMapping("/api/books")
	public ResponseEntity<List<Book>> getAll(){
		List<Book> list = bookService.getall();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/api/books/{id}")
	public ResponseEntity<Book> get(@PathVariable("id") long id){
		Book book = bookService.get(id);
		return ResponseEntity.ok().body(book);
	}
	
	@PostMapping("/api/books")
	public ResponseEntity<?> save(@RequestBody Book book){
		long id = bookService.save(book);
		return ResponseEntity.ok("Record has been added with ID"+id);
		
	}
	
	@PutMapping("/api/books/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Book book){
		bookService.update(id, book);
		return ResponseEntity.ok("Record has been Updated with ID"+id);
		
	}
	@DeleteMapping("/api/books/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id){
		bookService.delete(id);
		return ResponseEntity.ok("Record has been deleted with ID"+id);
		
	}
	
}

package com.spring.service;
import java.util.List;
import com.spring.Model.Book;

public interface BookService {

long save(Book book);

Book get(long id);

List<Book> getall();

void update(long id,Book book);

void delete(long id);
	
}

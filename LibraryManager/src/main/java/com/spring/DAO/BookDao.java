package com.spring.DAO;
import java.util.List;
import com.spring.Model.Book;

public interface BookDao {
	
long save(Book book);

Book get(long id);

List<Book> getall();

void update(long id,Book book);

void delete(long id);
}

package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.DAO.BookDao;
import com.spring.Model.Book;
@Service
public class BookServiceImplementation implements BookService {
	@Autowired
	private BookDao bookdao;
	@Override
	@Transactional
	public long save(Book book) {
		bookdao.save(book);
		return book.getId();
	}

	@Override
	@Transactional
	public Book get(long id) {
		return bookdao.get(id);
	}

	@Override
	@Transactional
	public List<Book> getall() {
		return bookdao.getall();
	}

	@Override
	@Transactional
	public void update(long id, Book book) {
		bookdao.update(id,book);
	}

	@Override
	@Transactional
	public void delete(long id) {
		bookdao.delete(id);
	}

}

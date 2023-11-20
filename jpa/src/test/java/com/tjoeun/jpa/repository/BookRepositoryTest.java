package com.tjoeun.jpa.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.tjoeun.jpa.domain.Book;

@SpringBootTest
class BookRepositoryTest {

	@Autowired
	private BookRepository bookRepository;
	
	@Test
	@Transactional
	public void bookTest() {
		Book book = new Book();
		book.setName("홍길동");
		book.setAuthor("간지나는 springBoot 책");
		book.setCreateAt(LocalDateTime.now());
		book.setUpdateAt(LocalDateTime.now());
		bookRepository.save(book);
		
		List<Book> books = bookRepository.findAll();
		books.forEach(System.out::println);
	}
	
}

package com.tuwaner.book.service;

import com.tuwaner.book.model.Book;
import com.tuwaner.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @date 2018/7/13
 */
@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override public Optional<Book> findOne(String id) {
        return bookRepository.findById(id);
    }

    @Override public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override public Page<Book> findByAuthor(String author, PageRequest pageRequest) {
        return bookRepository.findByAuthor(author, pageRequest);
    }

    @Override public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}

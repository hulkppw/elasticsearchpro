package com.tuwaner.book.repository;

import com.tuwaner.book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @date 2018/7/13
 */
public interface BookRepository extends ElasticsearchRepository<Book, String>{

    Page<Book> findByAuthor(String author, Pageable pageable);

    List<Book> findByTitle(String title);
}

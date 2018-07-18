package com.tuwaner;

import com.tuwaner.book.model.Book;
import com.tuwaner.book.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @date 2018/7/16
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private ElasticsearchTemplate esTemplate;

    public void before(){
        esTemplate.deleteIndex(Book.class);
        esTemplate.createIndex(Book.class);
        esTemplate.putMapping(Book.class);
        esTemplate.refresh(Book.class);
    }

    @Test
    public void testSave(){
        Book book = new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017");
        Book testBook = bookService.save(book);

        //assertNotNull(testBook.getId());
    }


    @Test
    public void testFindOne() {

        /*Book book = new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017");
        bookService.save(book);*/

        Optional<Book> testBook = bookService.findOne("1001");

        assertNotNull(testBook.get().getId());
        assertEquals(testBook.get().getTitle(), testBook.get().getTitle());
        assertEquals(testBook.get().getAuthor(), testBook.get().getAuthor());
        assertEquals(testBook.get().getReleaseDate(), testBook.get().getReleaseDate());

        System.out.println(testBook.get());
    }




















}

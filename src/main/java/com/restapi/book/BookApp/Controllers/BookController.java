package com.restapi.book.BookApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.book.BookApp.Entites.Book;
import com.restapi.book.BookApp.Services.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    // @RequestMapping(value = "/books", method = RequestMethod.GET) //Combination
    // of @RequestMapping(value = "/books", method = RequestMethod.GET) is combine
    // in single annotation i.e. is @GetMapping()
    @GetMapping("/books") // get all books handler
    public List<Book> getBook() {

        return this.bookService.getAllBook();

    }

    @GetMapping("/singlebook") // get single book handler
    public Book getSingleBook() {
        return this.bookService.getBookById(2);
    }

    @PostMapping("/books") // new book handler
    public Book addBook(@RequestBody Book book) {
        // get all data from request and store it into book object with help of
        // @RequestBody

        Book b = this.bookService.addBook(book);

        // System.out.println("this is new record " + book);
        return b;
    }

    @DeleteMapping("/books/{bookId}") // delete book handler
    public void deleteBook(@PathVariable("bookId") int bookId) {

        this.bookService.deleteBook(bookId);

    }

    @PutMapping("/books/{bookId}") // update book handler
    public Book updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {

        this.bookService.deleteBook(bookId);
        return book;

    }

}

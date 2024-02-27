package com.restapi.book.BookApp.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.restapi.book.BookApp.Entites.Book;

@Component
public class BookService {

    private static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(1, "Game Testing", "Rohan"));
        list.add(new Book(2, "Project Mang.", "Aditya"));
        list.add(new Book(3, "Web Application", "Tejas"));
        list.add(new Book(4, "App devlopment", "Akshay"));
    }

    // get all books

    public List<Book> getAllBook() {

        return list;
    }

    // get single book by id

    public Book getBookById(int id) {

        Book book = null;
        book = list.stream().filter(e -> e.getId() == id).findFirst().get(); // used to get individual book
        return book;
    }

    // Adding the books
    public Book addBook(Book b) {

        list.add(b);
        return b;

    }

    // delete Book
    public void deleteBook(int bookId) {

        list = list.stream().filter(book -> book.getId() != bookId).collect(Collectors.toList()); // condition

    }

    // update the book
    public void updateBook(Book book, int bookId) {
        list = list.stream().map(b -> {
            if (b.getId() == bookId) {
                b.setTitle(book.getTitle());
                b.setAuthors(book.getAuthors());
            }
            return b;
        }).collect(Collectors.toList());
    }
}

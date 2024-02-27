package com.restapi.book.BookApp.Entites;

public class Book {

    private int id;
    private String title;
    private String authors;

    public Book(int id, String title, String authors) {
        this.id = id;
        this.title = title;
        this.authors = authors;
    }

    public Book() {

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", authors=" + authors + "]";
    }

}

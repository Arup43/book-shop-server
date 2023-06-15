package com.internship.bookshop.service;

import com.internship.bookshop.entity.Book;

import java.util.List;

public interface BookService {
    public Book saveBook(Book book, Long bookshopId);

    public List<Book> fetchBookList();

    public Book fetchBookById(Long bookId);

    public void deleteBookById(Long bookId);

    public Book updateBook(Long bookId, Book book, Long bookshopId);

    public void deleteAllBooks();

    public Book fetchBookByTitle(String title);
}

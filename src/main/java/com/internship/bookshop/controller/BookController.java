package com.internship.bookshop.controller;

import com.internship.bookshop.entity.Book;
import com.internship.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @GetMapping("/")
    public String books() {
        return "Welcome to spring boot BOOK ShOP APP!";
    }

    @Autowired
    private BookService bookService;

    @PostMapping("/books")
    public Book saveBook(@RequestBody() Book book, @RequestParam("bookshopId") Long bookshopId) {
        return bookService.saveBook(book, bookshopId);
    }

    @GetMapping("/books")
    public List<Book> fetchBookList() {
        return bookService.fetchBookList();
    }

    @GetMapping("/books/{id}")
    public Book fetchBookById(@PathVariable("id") Long bookId) {
        return bookService.fetchBookById(bookId);
    }

    @GetMapping("/books/{title}")
    public Book fetchBookByTitle(@PathVariable("title") String title) {
        return bookService.fetchBookByTitle(title);
    }

    @DeleteMapping("/books/{id}")
    public String deleteBookById(@PathVariable("id") Long bookId) {
        bookService.deleteBookById(bookId);
        return "Book deleted successfully!";
    }

    @DeleteMapping("/books")
    public String deleteAllBooks() {
        bookService.deleteAllBooks();
        return "All books deleted successfully";
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable("id") Long bookId,
                           @RequestBody Book book, @RequestParam Long bookshopId) {
        return bookService.updateBook(bookId, book, bookshopId);
    }
}

package com.internship.bookshop.service;

import com.internship.bookshop.entity.Book;
import com.internship.bookshop.entity.BookShop;
import com.internship.bookshop.repository.BookRepository;
import com.internship.bookshop.repository.BookShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookShopRepository bookShopRepository;

    @Override
    public Book saveBook(Book book, Long bookshopId) {
        BookShop bookShop = bookShopRepository.findById(bookshopId)
                .orElseThrow(() -> new IllegalArgumentException("BookShop not found with ID: " + bookshopId));

        book.setBookShop(bookShop);

        return bookRepository.save(book);
    }

    @Override
    public List<Book> fetchBookList() {
        return bookRepository.findAll();
    }

    @Override
    public Book fetchBookById(Long bookId) {
        return bookRepository.findById(bookId).get();
    }

    @Override
    public void deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Book updateBook(Long bookId, Book book, Long bookshopId) {
        Book bookDB = bookRepository.findById(bookId).get();

        if (Objects.nonNull(book.getTitle()) &&
        !"".equalsIgnoreCase((book.getTitle()))) {
            bookDB.setTitle(book.getTitle());
        }

        if (Objects.nonNull(book.getPublisher()) &&
                !"".equalsIgnoreCase((book.getPublisher()))) {
            bookDB.setPublisher(book.getPublisher());
        }

        if (Objects.nonNull(book.getGenre()) &&
                !"".equalsIgnoreCase((book.getGenre()))) {
            bookDB.setGenre(book.getGenre());
        }

        bookDB.setPrice(book.getPrice());
        bookDB.setYearOfPublish(book.getYearOfPublish());

        BookShop bookShop = bookShopRepository.findById(bookshopId)
                .orElseThrow(() -> new IllegalArgumentException("BookShop not found with ID: " + bookshopId));

        book.setBookShop(bookShop);

        return bookRepository.save(bookDB);
    }

    @Override
    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }

    @Override
    public Book fetchBookByTitle(String title) {
        return bookRepository.findBookByTitle(title);
    }
}

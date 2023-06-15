package com.internship.bookshop.service;

import com.internship.bookshop.entity.BookShop;
import com.internship.bookshop.repository.BookShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookShopServiceImpl implements BookShopService{
    @Autowired
    private BookShopRepository bookShopRepository;

    @Override
    public List<BookShop> fetchBookShops() {
        return bookShopRepository.findAll();
    }

    @Override
    public BookShop fetchBookShopById(Long bookshopId) {
        return bookShopRepository.findById(bookshopId).get();
    }

    @Override
    public BookShop fetchBookShopByTitle(String title) {
        return bookShopRepository.findByShopName(title);
    }

    @Override
    public void deleteAllBookShop() {
        bookShopRepository.deleteAll();
    }

    @Override
    public void deleteByBookShopId(Long id) {
        bookShopRepository.deleteById(id);
    }

    @Override
    public BookShop saveBookShop(BookShop bookShop) {
        return bookShopRepository.save(bookShop);
    }

    @Override
    public BookShop updateBookShop(BookShop bookShop) {
        return bookShopRepository.save(bookShop);
    }
}
